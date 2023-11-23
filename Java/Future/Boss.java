package Future;

public class Boss implements Invest{

    private Company company;
    private int privateMoney;

    public Boss(Company company) {
        this.company = company;
        this.privateMoney = 10000000;
    }

    @Override
    public void investForCompany() {
            int CompanyValue = this.company.getValue();
            CompanyValue += privateMoney;
            this.privateMoney = 0;
            this.company.setValue(CompanyValue);
    }

    @Override
    public void stoleMoney() {
            this.privateMoney += company.getValue();
            this.company.setValue(0);

    }
}
