package cleancode.studycafe.mission.model;

public class StudyCafePass {

    private final StudyCafePassType passType;
    private final int duration;
    private final int price;
    private final double discountRate;

    private StudyCafePass(StudyCafePassType passType, int duration, int price, double discountRate) {
        this.passType = passType;
        this.duration = duration;
        this.price = price;
        this.discountRate = discountRate;
    }

    public static StudyCafePass of(StudyCafePassType passType, int duration, int price, double discountRate) {
        return new StudyCafePass(passType, duration, price, discountRate);
    }

    public StudyCafePassType getPassType() {
        return passType;
    }

    public int getDuration() {
        return duration;
    }

    public int getPrice() {
        return price;
    }

    public int getDiscountPrice() {
      return (int) discountRate * price;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public String display() {
        return passType.display(duration, price);
    }

    public String discountPricePrint() {
      int discountPrice = getDiscountPrice();
      if(discountPrice > 0) {
        return "이벤트 할인 금액: " + discountPrice + "원";
      }
      return null;
    }

  public int getTotalPrice() {
    return price - getDiscountPrice();
  }
}
