package pas.financial.models;

import java.util.ArrayList;

/**
 *
 * @author Ruben
 */
public class Clieop {
    /* Instance variables */
    private int outputType;
    
    private String principalAccount;
    private String transactionGroup;
    private String nawCode;
    private String duplicityType;
    private String filePath;
    private String email;
    private String collectionType;
    private String principalName;
    
    private String generalDescription;
    
    private ArrayList<String> clientDescription;
    private ArrayList<String> clientAccount;
    private ArrayList<String> clientName;
    private ArrayList<String> clientAddress;
    private ArrayList<String> clientAmount;
    private ArrayList<String> transactionType;
    
    /* Class Constants */
    
    /***** Output type *****/
    /**
     * public int SCREEN output file to screen
     */
    public static final int SCREEN = 1;
    /**
     * public int SAVE save file to disc
     */
    public static final int SAVE = 2;
    
    /**
     * public int EMAIL send the file via email
     */
    public static final int EMAIL = 3;
    
    /**
     * public int PRINT print the file on document
     */
    public static final int PRINT = 4;
    
    /***** Transaction Group *****/
    
    /**
     * public String Payment payment to clients
     */
    public static final String PAYMENT = "00";
    
    /**
     * public String Collection collection from clients
     */
    public static final String COLLECTION = "10";
    
    /***** NAW Setting *****/
    /**
     * public String WITHNAME export collection data with NAW data
     */
    public static final String WITHNAME = "1";
    
    /**
     * public String WHITHOUTNAME export collection data withouw NAW data
     */
    public static final String WITHOUTNAME = "2";
    
    /***** Export type ******/
    /**
     * public String ORIGINAL export is original file
     */
    public static final String ORIGINAL = "1";
    
    /**
     * public String DUPLICATE export file is duplicate file
     */
    public static final String DUPLICATE = "2";
    
    
    /***** Transaction type *****/
    /**
     * public String PARTIAL_CREDITPAYMENT
     */
    public static final String PARTIAL_CREDITPAYMENT = "0000";
    
    /**
     * public String FULL_CREDITPAYMENT
     */
    public static final String FULL_CREDITPAYMENT  = "0005";
    
    /**
     * public String PARTIAL_SALARYPAYMENT
     */
    public static final String PARTIAL_SALARYPAYMENT  = "0003";
    
    /**
     * public String FULL_SALARYPAYMENT
     */
    public static final String FULL_SALARYPAYMENT  = "0008";
    
    /**
     * public STRING PARTIAL_COLLECTION
     */
    public static final String PARTIAL_COLLECTION  = "1002";
            
    /**
     * public String FULL_COLLECTION
     */
    public static final String FULL_COLLECTION  = "1001";
            
    /***** Get Methods *****/
    /**
     * Get the current selected output type for the file
     * @return int outputType
     */
    public int getOutputType() {
        return this.outputType;
    }
    
    /**
     * get the current set transaction type
     * @return int Transaction type
     */
    public String getTransactionGroup() {
        return this.transactionGroup;
    }

    /**
     *
     * @return
     */
    public String getNawCode() {
        return this.nawCode;
    }

    /**
     *
     * @return
     */
    public String getDuplicityType() {
        return this.duplicityType;
    }

    /**
     * Get the set Email address when using the output type EMAIL
     * @return String
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * Set the output type to either SCREEN, SAVE, EMAIL or PRINT using the class constants
     * @param outputType
     */
    public void setOutputType(int outputType) {
        this.outputType = outputType;
    }
    
    /**
     * 
     * @param transactionGroup
     */
    public void setTransactionGroup(String transactionGroup) {
        this.transactionGroup = transactionGroup;
    }

    /**
     *
     * @param nawCode
     */
    public void setNawCode(String nawCode) {
        this.nawCode = nawCode;
    }

    /**
     *
     * @param duplicityType
     */
    public void setDuplicityType(String duplicityType) {
        this.duplicityType = duplicityType;
    }

    /**
     *
     * @param String email
     */
    public void setEmail(String email) {
        this.email = email;
    }
    
    /**
     *
     */
    public Clieop(){
        this.outputType = Clieop.SCREEN;
        this.collectionType = "10";
        
        this.clientAmount = new ArrayList<>();
        this.clientAccount = new ArrayList<>();
        this.clientName = new ArrayList<>();
        this.clientAddress = new ArrayList<>();
        this.clientDescription = new ArrayList<>();
    }
    
    /**
     * Add client info with typical account number
     */
    public void addClient(String name, String address, Integer account, double amount, String transactionType, String description) throws Exception {
        if(!this.validateAccount(account)){
            throw new Exception("Wrong account format");
        }
        
        int tmp = (int) amount * 100;
        
        this.clientAmount.add(new Double(tmp).toString());
        this.clientAccount.add(account.toString());
        this.clientName.add(name);
        this.clientAddress.add(address);
        this.clientDescription.add(description);
        this.transactionType.add(transactionType);
    }
    
    /**
     * 
     */
    public void setPrincipal(String name, Integer account){
        this.principalName = name;
        this.principalAccount = account.toString();
    }
    
    /**
     *
     */
    public void generate()  throws Exception {
        String contents = "";
        String date = "010113";
        Double transactionTotal = 0.0;
        
        /****** check variables existence first *******/
        if(this.principalName       == null) throw new Exception("No principal name set");
        if(this.principalAccount    == null) throw new Exception("No principal account set");
        if(this.transactionGroup    == null) throw new Exception("No transaction group set");
        if(this.transactionType     == null) throw new Exception("No transaction type set");
        if(this.collectionType      == null) throw new Exception("No collection type set");
        if(this.generalDescription  == null) throw new Exception("No general description set");
        if(this.nawCode             == null) throw new Exception("No NAW code set");
        if(this.outputType          == Clieop.SAVE && this.filePath == null) throw new Exception("No file path set");
        if(this.outputType          == Clieop.EMAIL && this.email == null) throw new Exception("No email set");
        if(this.duplicityType       == null) throw new Exception("No duplicity type set");
        if(this.clientAccount.size() == 0) throw new Exception("No transaction set");
        
        /** The principal name must be 35 characters long **/
        while(this.principalName.length() < 35) {
            this.principalName += " ";
        }
        
        if(this.principalName.length() > 35){
            String name = this.principalName.substring(0, 35);
            this.principalName = name;
        }
        
        /** The principal account must be 10 characters long **/
        String principalAccount = new Integer(this.principalAccount).toString();
        while(principalAccount.length() < 10){
            principalAccount = "0"+principalAccount;
        }
        
        if(principalAccount.length() > 10) {
            throw new Exception("Invalid account specified");
        }
        
        contents =  "0001A" + date + "CLIEOP03         " + this.duplicityType +"                     \n" +
                    "0010B" + this.transactionGroup + this.principalAccount + "0001EUR                          \n" + 
                    "0030B" + this.nawCode + date + this.principalName + "  P";
        
        /** The client details **/
        String clientcontents = "";
        int size = this.clientName.size();
        for(int i = 0; i < size; i++){
            String clientAccount = this.clientAccount.get(i);
            String clientName = this.clientName.get(i);
            String clientAddress = this.clientAddress.get(i);
            String description = this.generalDescription + this.clientDescription.get(i);
            String clientAmount = this.clientAmount.get(i);
            String clientTransactionType = this.transactionType.get(i);
            
            /** The client name must be 35 characters long **/
            while(clientName.length() < 35){
                clientName += " ";
            }
            
            if(clientName.length() > 45){
                clientName = clientName.substring(0, 35);
            }
            
            /** The account must be 10 characters long **/
            while(clientAccount.length() < 10){
                clientAccount += "0";
            }
            
            /** The description must be 32 characters long **/
            while(description.length() < 45){
                description += " ";
            }
            
            if(description.length() > 32){
                description = description.substring(0, 32);
            }
            
            /** The address must be 45 characters long **/
            while(clientAddress.length() < 45){
                clientAddress += " ";
            }
            
            if(clientAddress.length() > 45){
                clientAddress = clientAddress.substring(0, 45);
            }
            
            clientcontents = "0100A"+clientTransactionType+clientAmount+principalAccount+clientAccount;
            
            while(clientcontents.length() < 50){
                clientcontents += " ";
            }
            clientcontents += "\n";
            
            clientcontents += "0160A"+description+"\n";
            clientcontents += "0170B"+clientName+"\n";
            clientcontents += "0173B"+clientAddress+"\n";
            
            contents += clientcontents;
            clientcontents = "";
            transactionTotal += Double.parseDouble(clientAmount);
        }
        
        String transactionCount = new Integer(this.clientAccount.size()).toString();
        while(transactionCount.length() < 10){
            transactionCount = "0"+transactionCount;
        }
        
        String last = "9990A" + transactionTotal+(new Integer(this.clientAccount.size()).toString()+new Integer(this.clientAccount.size()).toString());
        
        while(last.length() < 50){
            last += " ";
        }
        
        contents += "9999A                                             ";
    }
    
    
    /**
     * validation for typical accounts
     * @param account
     * @return 
     */
    private boolean validateAccount(int account){
        String clAccount = new Integer(account).toString();
        while(clAccount.length() < 10){
            clAccount = "0"+clAccount;
        }
        
        int count = 0;
        for(int i = 0; i < 10; i++){
            count += (clAccount.charAt(i) * i);
        }
        
        return count % 11 == 0;
    }
}
