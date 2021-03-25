package model;

public class ContractDetail {

    private Long id;
    private int quantity;
    private Contract contract;
    private ExtraService extraService;

    public ContractDetail() {
    }

    public ContractDetail(Long id, int quantity, Contract contract, ExtraService extraService) {
        this.id = id;
        this.quantity = quantity;
        this.contract = contract;
        this.extraService = extraService;
    }

    public ContractDetail(int quantity, Contract contract, ExtraService extraService) {
        this.quantity = quantity;
        this.contract = contract;
        this.extraService = extraService;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public ExtraService getExtraService() {
        return extraService;
    }

    public void setExtraService(ExtraService extraService) {
        this.extraService = extraService;
    }
}
