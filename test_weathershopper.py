import pytest
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC


class TestWeatherShopper:

    @pytest.fixture(scope="class")
    def setup(self):
        self.driver = webdriver.Chrome()
        self.driver.maximize_window()
        self.driver.implicitly_wait(10)
        yield
        self.driver.quit()

    def test_purchase_flow(self, setup):
        self.driver.get("http://weathershopper.pythonanywhere.com/moisturizer")
        assert "Moisturizer" in self.driver.title

        product = self.driver.find_element(By.XPATH, "//div[contains(text(),'Aloe')]/following-sibling::p/a")
        product.click()

        wait = WebDriverWait(self.driver, 10)
        wait.until(EC.element_to_be_clickable((By.NAME, "commit")))

        self.driver.find_element(By.NAME, "commit").click()

        wait.until(EC.element_to_be_clickable((By.XPATH, "//a[text()='Add']")))
        self.driver.find_element(By.XPATH, "//a[text()='addToCart']").click()

        wait.until(EC.element_to_be_clickable((By.XPATH, "//a[text()='Cart']")))
        self.driver.find_element(By.XPATH, "//a[text()='goToCart']").click()

        wait.until(EC.element_to_be_clickable((By.XPATH, "//a[text()='Pay With Card']")))
        self.driver.find_element(By.XPATH, "//a[text()='payWithCard']").click()

        self.driver.find_element(By.ID, "email").send_keys("abubakarqasim2518@gmail.com")
        self.driver.find_element(By.ID, "card_number").send_keys("4242 4242 4242 4242")
        self.driver.find_element(By.ID, "cc_exp").send_keys("03 / 23")
        self.driver.find_element(By.ID, "cc_csc").send_keys("123")
        self.driver.find_element(By.ID, "_zip").send_keys("4400")


        self.driver.find_element(By.Class, "commit").click()

        wait.until(EC.element_to_be_clickable((By.XPATH,
                                               "//h2[text()='Your payment was successful. You should receive a follow-up call from our sales team.']")))
        assert "Your payment was successful. You should receive a follow-up call from our sales team." in self.driver.page_source