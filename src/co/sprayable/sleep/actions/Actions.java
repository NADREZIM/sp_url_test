package co.sprayable.sleep.actions;

import qa.util.base.BaseActions;
import qa.util.base.ObjectsCollection;

public final class Actions {
    private static ObjectsCollection<BaseActions> actions = new ObjectsCollection<>();

    public static void clear() {
        actions.clear();
    }

    public static MainActions mainActions() { return actions.getInstance(MainActions.class); }

    public static TakeSleepTypeQuizAction takeSleepTypeQuizAction() { return actions.getInstance(TakeSleepTypeQuizAction.class); }

    public static CheckoutAction checkoutAction() {
        return actions.getInstance(CheckoutAction.class);
    }

    public static GetsSleepAction getsSleepAction() {
        return actions.getInstance(GetsSleepAction.class);
    }

    public static PowerfulFoodsActions powerfulFoodsActions() { return actions.getInstance(PowerfulFoodsActions.class); }

    public static CheatSheetThankYouActions cheatSheetThankYouActions() { return actions.getInstance(CheatSheetThankYouActions.class); }

    public static CheatSheetActions cheatSheetActions() { return actions.getInstance(CheatSheetActions.class); }

    public static LimitedTimeOfferActions limitedTimeOfferActions() { return actions.getInstance(LimitedTimeOfferActions.class); }

    public static UltimateOfferActions ultimateOfferActions() { return actions.getInstance(UltimateOfferActions.class); }

    public static SleepSpecialOfferActions sleepSpecialOfferActions() { return actions.getInstance(SleepSpecialOfferActions.class); }

    public static SpecialAffordableOfferActions specialAffordableOfferActions() {
       return actions.getInstance(SpecialAffordableOfferActions.class);
    }

    public static SleepSprayableVslActions sleepSprayableVslActions() { return actions.getInstance(SleepSprayableVslActions.class ); }

    public static OrderActions orderActions() { return actions.getInstance(OrderActions.class); }

    public static SleepSprayableVipActions sleepSprayableVipActions() {
        return actions.getInstance(SleepSprayableVipActions.class); }

    public static SleepSprayableVipFreeActions sleepSprayableVipFreeActions() {
        return actions.getInstance(SleepSprayableVipFreeActions.class);
    }

    public static OrderFreeTrialSubscriptionActions orderFreeTrialSubscriptionActions() {
        return actions.getInstance(OrderFreeTrialSubscriptionActions.class);
    }

    public static SpecialOrderActions specialOrderActions() { return actions.getInstance(SpecialOrderActions.class); }

    public static OrderGetSleepActions orderGetSleepActions() { return actions.getInstance(OrderGetSleepActions.class); }

    public static OrderFreeTrialActions orderFreeTrialActions() { return actions.getInstance(OrderFreeTrialActions.class); }

    public static GetSleepTwoActions getSleepTwoActions() { return actions.getInstance(GetSleepTwoActions.class); }

    public static GetFreeTrialActions getFreeTrialActions() { return actions.getInstance(GetFreeTrialActions.class); }

    public static NoMoreJetLagActions noMoreJetLagActions() { return actions.getInstance(NoMoreJetLagActions.class); }

    public static EnergyLifetimeSubscriptionActions energyLifetimeSubscriptionActions() {
        return actions.getInstance(EnergyLifetimeSubscriptionActions.class);
    }

    public static IggOrderSpecialActions iggOrderSpecialActions() { return actions.getInstance(IggOrderSpecialActions.class); }

    public static SubscriberOfferActions subscriberOfferActions() { return actions.getInstance(SubscriberOfferActions.class); }

    public static HomeNewActions homeNewActions() { return actions.getInstance(HomeNewActions.class); }

    public static SleepHackerActions sleepHackerActions() { return actions.getInstance(SleepHackerActions.class); }
}