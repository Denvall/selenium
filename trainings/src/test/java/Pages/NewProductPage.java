package Pages;

import org.openqa.selenium.WebDriver;

/**
 * Created by denvall on 20.06.17.
 */
    public class NewProductPage extends PageObject {


    public NewProductPage(WebDriver driver) {
        super(driver);
    }
    //General tab
    private String tabGeneral = "#tab-general ";
    private String tabs = "#tabs ";
    private String name = tabGeneral + "input[name='name[en]']";
    private String code = tabGeneral + "input[name='code']";
    private String category = tabGeneral + "input[data-name='Rubber Ducks']";
    private String sex = tabGeneral + "input[name='product_groups[]']";
    private String quantity = tabGeneral + "input[name='quantity']";
    private String soldOutStatus = tabGeneral + "input[name='sold_out_status_id']";
    private String newImage = tabGeneral + "input[name='new_images[]']";
    private String dateValidFrom = tabGeneral + "input[name='date_valid_from']";
    private String dateValidTo = tabGeneral + "input[name='date_valid_to']";
    //Tabs
    private String tabInformation = tabs + "li:nth-child(2)";
    private String tabPrices = tabs + "li:nth-child(4)";
    //Information tab
    private String manufacter ="#tab-information select[name='manufacturer_id']";
    private String supplier ="#tab-information select[name='supplier_id']";
    private String keyword ="#tab-information input[name='keywords']";
    private String shortDescription ="#tab-information input[name='short_description[en]']";
    private String Description ="#tab-information  div.trumbowyg-editor";
    private String headTitle="#tab-information input[name='head_title[en]']";
    private String metaDesciption="#tab-information input[name='meta_description[en]']";
    //Prices tab

    private String purchasePrice ="#tab-prices input[name='purchase_price']";
    private String priceUSDTax ="#tab-prices input[name='prices[USD]']";
    private String priceEURTax ="#tab-prices input[name='prices[EUR]']";
    private String currencySelect ="#tab-prices select[name='purchase_price_currency_code']";

    //Buttons
    private String saveButton ="form span.button-set button[name='save']";








}
