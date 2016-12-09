package co.sprayable.sleep.pages;

import qa.util.base.BasePage;
import qa.util.base.ObjectsCollection;

public final class Pages {
    private static ObjectsCollection<BasePage> pages = new ObjectsCollection<>();

    public static void clear() {
        pages.clear();
    }

    public static TakeSleepTypePage takeSleepTypePage() {
        return pages.getInstance(TakeSleepTypePage.class);
    }

    public static SleepTypeDiscountOfferPage sleepTypeDiscountOfferPage() {
        return pages.getInstance(SleepTypeDiscountOfferPage.class);
    }

    public static DiscountOfferPage discountOfferPage() {
        return pages.getInstance(DiscountOfferPage.class);
    }

    public static CheckoutPage checkoutPage() {
        return pages.getInstance(CheckoutPage.class);
    }

    public static SpecialOffersPage specialOffersPage() {
        return pages.getInstance(SpecialOffersPage.class);
    }

    public static ThankyouPage thankyouPage() {
        return pages.getInstance(ThankyouPage.class);
    }

    public static GetsSleepPage getsSleepPage() {
        return pages.getInstance(GetsSleepPage.class);
    }

    public static OrderGetSleepPage orderGetSleepPage() {
        return pages.getInstance(OrderGetSleepPage.class);
    }

    public static CureYourInsomniaPage cureYourInsomniaPage() {
        return pages.getInstance(CureYourInsomniaPage.class);
    }

    public static FallAsleepFasterPage fallAsleepFasterPage() {return pages.getInstance(FallAsleepFasterPage.class);}

    public static PowerfulFoodsToFallAsleep powerfulFoodsToFallAsleep () {
        return pages.getInstance(PowerfulFoodsToFallAsleep.class);
    }

    public static CheatSheetThankYouPage cheatSheetThankYouPage() {
        return pages.getInstance(CheatSheetThankYouPage.class);
    }

    public static CheatSheetPage cheatSheetPage () {return pages.getInstance(CheatSheetPage.class); }

    public static LimitedTimeOfferPage limitedTimeOfferPage () { return pages.getInstance(LimitedTimeOfferPage.class); }

    public static UltimateOfferPage ultimateOfferPage() { return pages.getInstance(UltimateOfferPage.class); }

    public static SleepSpecialOfferPage sleepSpecialOfferPage() { return pages.getInstance(SleepSpecialOfferPage.class); }

    public static FreeTrialPage freeTrialPage() { return pages.getInstance(FreeTrialPage.class); }

    public static OrderFreeTrialPage orderFreeTrialPage() { return pages.getInstance(OrderFreeTrialPage.class); }

    public static SpecialAffordableOfferPage specialAffordableOfferPage() {
        return pages.getInstance(SpecialAffordableOfferPage.class);
    }

    public static SleepSprayablePage sleepSprayablePage() { return pages.getInstance(SleepSprayablePage.class); }

    public static SleepSprayableVslPage sleepSprayableVslPage() { return pages.getInstance(SleepSprayableVslPage.class); }

    public static SprayableEnergyPage sprayableEnergyPage() { return pages.getInstance(SprayableEnergyPage.class); }

    public static DiscountOfferEightPage discountOfferEightPage() { return pages.getInstance(DiscountOfferEightPage.class); }

    public static OrderPage orderPage() { return pages.getInstance(OrderPage.class); }

    public static SleepSprayableVipPage sleepSprayableVipPage() { return pages.getInstance(SleepSprayableVipPage.class); }

    public static SleepSprayableVipFreePage sleepSprayableVipFreePage() {
        return pages.getInstance(SleepSprayableVipFreePage.class);
    }

    public static OrderFreeTrialSubscriptionPage orderFreeTrialSubscriptionPage() {
        return pages.getInstance(OrderFreeTrialSubscriptionPage.class);
    }

    public static TrySprayablesSeepFirstMonthFreePage trySprayablesSeepFirstMonthFreePage() {
        return pages.getInstance(TrySprayablesSeepFirstMonthFreePage.class);
    }

    public static TrySprayableSleepFirstMonthOneDollarPage trySprayableSleepFirstMonthOneDollarPage() {
        return pages.getInstance(TrySprayableSleepFirstMonthOneDollarPage.class);
    }

    public static EnergyTrialPage energyTrialPage() { return pages.getInstance(EnergyTrialPage.class); }

    public static SpecialOrderPage specialOrderPage() { return pages.getInstance(SpecialOrderPage.class); }

    public static GetSleepTwoPage getSleepTwoPage() { return pages.getInstance(GetSleepTwoPage.class); }

    public static GetFreeTrialPage getFreeTrialPage() { return pages.getInstance(GetFreeTrialPage.class); }

    public static NoMoreJetLagPage noMoreJetLagPage() { return pages.getInstance(NoMoreJetLagPage.class); }

    public static EnergyLifetimeSubscriptionPage energyLifetimeSubscriptionPage() {
        return pages.getInstance(EnergyLifetimeSubscriptionPage.class);
    }

    public static IggOrderSpecialPage iggOrderSpecialPage() { return pages.getInstance(IggOrderSpecialPage.class); }

    public static SubscriberOfferPage subscriberOfferPage() { return pages.getInstance(SubscriberOfferPage.class); }

    public static HomeNewPage homeNewPage() { return pages.getInstance(HomeNewPage.class); }

    public static ProductsSleepPage productsSleepPage() { return pages.getInstance(ProductsSleepPage.class); }

    public static ProductsEnergyPage productsEnergyPage() { return pages.getInstance(ProductsEnergyPage.class); }

    public static SleepHackerPage sleepHackerPage() { return pages.getInstance(SleepHackerPage.class); }

    public static SprayablesleepPage sprayablesleepPage() { return  pages.getInstance(SprayablesleepPage.class); }

    public static SprayablePage sprayablePage() { return pages.getInstance(SprayablePage.class); }

    public static ProductsSprayableSleepPage productsSprayableSleepPage() {
        return pages.getInstance(ProductsSprayableSleepPage.class);
    }

    public static OrderFreeTrialWithQuestionMarkPage orderFreeTrialWithQuestionMarkPage() {
        return pages.getInstance(OrderFreeTrialWithQuestionMarkPage.class);
    }
}