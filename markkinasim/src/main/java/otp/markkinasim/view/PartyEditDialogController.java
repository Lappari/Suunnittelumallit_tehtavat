package otp.markkinasim.view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import otp.markkinasim.model.IProduct;
import otp.markkinasim.partyModel.IParty;

public class PartyEditDialogController {
	
	private Stage dialogStage;
    private IParty party;
    private boolean okClicked = false;
    private IView view;
    @FXML
    private TextField partyName;
    @FXML
    private ChoiceBox<String> partyProductChoice;
    @FXML
    private TextField partyMoney;
    @FXML 
    private TextField partyRawmaterial;

//inits
  	@FXML
    private void initialize() {

  	}
  	
  	public void setView(View view) {
  		this.view = view;
  		if(!view.getAllProductData().isEmpty()) {
  			for(IProduct i:view.getAllProductData()) {
  				partyProductChoice.getItems().add(i.getProductName());
  			}
  		}
  	}
	public Stage getDialogStage() {
		return dialogStage;
	}
	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}
	
	public void setParty(IParty party) {
		this.party = party;

		partyName.setText(party.getPartyName());
		if(party.productToProduceProperty()!=null) {
			for(IProduct i:view.getAllProductData()) {
				if(i.getId()==party.getProductToProduce()) {
					partyProductChoice.setValue(i.getProductName());
				}
			}
		
		}
		partyMoney.setText(Float.toString(party.getMoney()));

	}
	
	@FXML
	public void handleProductChoice() {
		for(IProduct i:view.getAllProductData()) {
			if(i.getProductName() == partyProductChoice.getValue()) {
				if(i.getProductNeededId()>=0) {
					for(IProduct I:view.getAllProductData()) {
						if(i.getProductNeededId() == I.getId()) {
							partyRawmaterial.setText(I.getProductName());
							break;
						}
					}
				}else {
					partyRawmaterial.setText("Raaka-ainetta ei tarvita.");
					break;
				}
			}
		}
	}
	
	public boolean isOkClicked() {
		return okClicked;
	}
	public void setOkClicked(boolean okClicked) {
		this.okClicked = okClicked;
	}
	
	//asettaa raaka-aineet ja tuotettavat tuotteet k�ytt�j�n valitseman taho tyypin mukaan.
		
	@FXML
	private void handleCancel() {
	    dialogStage.close();
	}
	
	@FXML
	   private void handleOk() {
	       if (isInputValid()) {
	           party.setPartyName(partyName.getText());
	           for(IProduct i:view.getAllProductData()) {
	        	   if(partyProductChoice.getValue() == i.getProductName()) {
	        		   party.setProductToProduce(i.getId());
	        	   }
	           }
	           party.setMoney(Float.parseFloat(partyMoney.getText()));

	           okClicked = true;
	           dialogStage.close();
	       }
	}
	
	@FXML
	private boolean isInputValid() {
        String errorMessage = "";

        if (partyName.getText() == null || partyName.getText().length() == 0) {
            errorMessage += "Nime� taho!\n"; 
        }
        
        if (partyProductChoice.getValue() == null) {
            errorMessage += "Valitse tahon tuottama tuote!\n"; 
        }

        if (partyMoney.getText() == null || partyMoney.getText().length() == 0) {
            errorMessage += "Tahon aloitus raham��r� on virheellinen!\n"; 
        } else {
            // try to parse the money amount into an float.
            try {
                Float.parseFloat(partyMoney.getText());
            } catch (NumberFormatException e) {
                errorMessage += "Tahon aloitus raham��r�n t�ytyy olla numero!\n"; 
            }
        }

        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message.
            Alert alert = new Alert(AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Korjaa v��rin t�ytetyt kent�t");
            alert.setContentText(errorMessage);
            
            alert.showAndWait();
            
            return false;
        }
    }
    
}
