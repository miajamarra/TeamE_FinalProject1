package org.example.teamerestaurant;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class menuOrder {
    public void openMenuOrderGUI() throws IOException {
        Stage menuOrderstage = new Stage();
        FXMLLoader menuOrderfxmlLoader = new FXMLLoader(mainGUIController.class.getResource("menuOrderViewPage.fxml"));
        Scene menuOrderscene = new Scene(menuOrderfxmlLoader.load(),500,700);
        menuOrderstage.setTitle("order menu");
        menuOrderstage.setScene(menuOrderscene);
        menuOrderstage.show();
    }
    onlineOrderInfoPT1 onlineOrderPt1 = new onlineOrderInfoPT1();
    @FXML
    protected void onContinueButtonClick() throws IOException {
        onlineOrderPt1.openOnlineOrderGUI();
    }
    int itemAmountHamburb = 0;
    int itemAmountCheeseburb = 0;
    int itemAmountImpossiburb = 0;
    int itemAmountTender3pc = 0;
    int itemAmountTender5pc = 0;
    int itemAmountNugget5pc = 0;
    int itemAmountNugget8pc = 0;
    int itemAmountApple = 0;
    int itemAmountMac = 0;
    int itemAmountTater = 0;
    int itemAmountFrothie = 0;

    double totalCost = 0;
    public double addPrices(double cost, double currentCost){
        return currentCost + cost;
    }
    public double subtractPrices(double cost, double currentCost){
        return currentCost - cost;
    }
    @FXML
    protected void onHamburberPlusButtonClick(){
        totalCost = addPrices(5.5, totalCost);
        hamburberSum.setText(String.valueOf(itemAmountHamburb += 1));
        finalCost.setText(String.valueOf(totalCost));
    }
    @FXML
    protected void onHamburberMinusButtonClick(){
        totalCost = subtractPrices(5.5, totalCost);
        hamburberSum.setText(String.valueOf(itemAmountHamburb -= 1));
        finalCost.setText(String.valueOf(totalCost));
    }
    @FXML
    protected void onCheeseburberPlusButtonClick(){
        totalCost = addPrices(6.5, totalCost);
        cheeseburberSum.setText(String.valueOf(itemAmountCheeseburb += 1));
        finalCost.setText(String.valueOf(totalCost));
    }
    @FXML
    protected void onCheeseburberMinusButtonClick(){
        totalCost = subtractPrices(6.5, totalCost);
        cheeseburberSum.setText(String.valueOf(itemAmountCheeseburb -= 1));
        finalCost.setText(String.valueOf(totalCost));
    }
    @FXML
    protected void onImpossiburberPlusButtonClick(){
        totalCost = addPrices(7.5, totalCost);
        impossiburberSum.setText(String.valueOf(itemAmountImpossiburb += 1));
        finalCost.setText(String.valueOf(totalCost));
    }
    @FXML
    protected void onImpossiburberMinusButtonClick(){
        totalCost = subtractPrices(7.5, totalCost);
        impossiburberSum.setText(String.valueOf(itemAmountImpossiburb -= 1));
        finalCost.setText(String.valueOf(totalCost));
    }
    @FXML
    protected void onTender3pcPlusButtonClick(){
        totalCost = addPrices(4,totalCost);
        tender3pcSum.setText(String.valueOf(itemAmountTender3pc += 1));
        finalCost.setText(String.valueOf(totalCost));
    }
    @FXML
    protected void onTender3pcMinusButtonClick(){
        totalCost = subtractPrices(4,totalCost);
        tender3pcSum.setText(String.valueOf(itemAmountTender3pc -= 1));
        finalCost.setText(String.valueOf(totalCost));
    }
    @FXML
    protected void onTender5pcPlusButtonClick(){
        totalCost = addPrices(5.5,totalCost);
        tender5pcSum.setText(String.valueOf(itemAmountTender5pc += 1));
        finalCost.setText(String.valueOf(totalCost));
    }
    @FXML
    protected void onTender5pcMinusButtonClick(){
        totalCost = subtractPrices(5.5,totalCost);
        tender5pcSum.setText(String.valueOf(itemAmountTender5pc -= 1));
        finalCost.setText(String.valueOf(totalCost));
    }
    @FXML
    protected void onNugget5pcPlusButtonClick(){
        totalCost = addPrices(5,totalCost);
        nugget5pcSum.setText(String.valueOf(itemAmountNugget5pc += 1));
        finalCost.setText(String.valueOf(totalCost));
    }
    @FXML
    protected void onNugget5pcMinusButtonClick(){
        totalCost = subtractPrices(5,totalCost);
        nugget5pcSum.setText(String.valueOf(itemAmountNugget5pc -= 1));
        finalCost.setText(String.valueOf(totalCost));
    }
    @FXML
    protected void onNugget8pcPlusButtonClick(){
        totalCost = addPrices(6.5,totalCost);
        nugget8pcSum.setText(String.valueOf(itemAmountNugget8pc += 1));
        finalCost.setText(String.valueOf(totalCost));
    }
    @FXML
    protected void onNugget8pcMinusButtonClick(){
        totalCost = subtractPrices(6.5, totalCost);
        nugget8pcSum.setText(String.valueOf(itemAmountNugget8pc -= 1));
        finalCost.setText(String.valueOf(totalCost));
    }
    @FXML
    protected void onTaterPlusButtonClick(){
        totalCost = addPrices(3,totalCost);
        taterSum.setText(String.valueOf(itemAmountTater += 1));
        finalCost.setText(String.valueOf(totalCost));
    }
    @FXML
    protected void onTaterMinusButtonClick(){
        totalCost = subtractPrices(3,totalCost);
        taterSum.setText(String.valueOf(itemAmountTater -= 1));
        finalCost.setText(String.valueOf(totalCost));
    }
    @FXML
    protected void onApplePlusButtonClick(){
        totalCost = addPrices(3,totalCost);
        appleSum.setText(String.valueOf(itemAmountApple += 1));
        finalCost.setText(String.valueOf(totalCost));
    }
    @FXML
    protected void onAppleMinusButtonClick(){
        totalCost = subtractPrices(3,totalCost);
        appleSum.setText(String.valueOf(itemAmountApple -= 1));
        finalCost.setText(String.valueOf(totalCost));
    }
    @FXML
    protected void onFrothiePlusButtonClick(){
        totalCost = addPrices(4,totalCost);
        frothieSum.setText(String.valueOf(itemAmountFrothie += 1));
        finalCost.setText(String.valueOf(totalCost));
    }
    @FXML
    protected void onFrothieMinusButtonClick(){
        totalCost = subtractPrices(4,totalCost);
        frothieSum.setText(String.valueOf(itemAmountFrothie -= 1));
        finalCost.setText(String.valueOf(totalCost));
    }
    @FXML
    protected void onMacPlusButtonClick(){
        totalCost = addPrices(3,totalCost);
        macSum.setText(String.valueOf(itemAmountMac += 1));
        finalCost.setText(String.valueOf(totalCost));
    }
    @FXML
    protected void onMacMinusButtonClick(){
        totalCost = subtractPrices(3,totalCost);
        macSum.setText(String.valueOf(itemAmountMac -= 1));
        finalCost.setText(String.valueOf(totalCost));
    }
    @FXML
    private Label hamburberSum;
    @FXML
    private Label cheeseburberSum;
    @FXML
    private Label impossiburberSum;
    @FXML
    private Label tender3pcSum;
    @FXML
    private Label tender5pcSum;
    @FXML
    private Label nugget5pcSum;
    @FXML
    private Label nugget8pcSum;
    @FXML
    private Label taterSum;
    @FXML
    private Label macSum;
    @FXML
    private Label frothieSum;
    @FXML
    private Label appleSum;
    @FXML
    private Label finalCost;

}
