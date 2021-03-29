package lotto.domain;

public class PurchaseAmount {
    private final int money;

    public PurchaseAmount(int money) {
        this(money, 0);
    }

    public PurchaseAmount(int money, int numberOfManualGames) {
        if (money < LottoRule.price()) {
            throw new IllegalArgumentException("구매금액은 1000원 이상이여야 합니다.");
        }

        if (money < numberOfManualGames * LottoRule.price()) {
            throw new IllegalArgumentException("구매 금액이 부족합니다.");
        }

        this.money = money;
    }

    public int numberOfGames() {
        return money / LottoRule.price();
    }

    public int purchaseAmount() {
        return money / LottoRule.price() * LottoRule.price();
    }
}
