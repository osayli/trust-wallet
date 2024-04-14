package pages;

public class AllPage {

    public AllPage() {

    }

    private OnboardingPage onBoardingPage;
    private ConnectWalletPage connectWalletPage;
    private CreateWalletPage createWalletPage;
    private BackUpPage backUpPage;
    private PasscodePage passcodePage;

    public OnboardingPage onBoardingPage(){
        if (onBoardingPage == null){
            onBoardingPage = new OnboardingPage();
        }return onBoardingPage;
    }

    public ConnectWalletPage connectWalletPage(){
        if (connectWalletPage == null){
            connectWalletPage = new ConnectWalletPage();
        }return connectWalletPage;
    }

    public CreateWalletPage createWalletPage(){
        if (createWalletPage == null){
            createWalletPage = new CreateWalletPage();
        }return createWalletPage;
    }

    public BackUpPage backUpPage(){
        if (backUpPage == null){
            backUpPage = new BackUpPage();
        }return backUpPage;
    }

    public PasscodePage passcodePage(){
        if (passcodePage == null){
            passcodePage = new PasscodePage();
        }return passcodePage;
    }

}
