package cleancode.studycafe.tobe.model.order;

import cleancode.studycafe.tobe.model.pass.locker.StudyCafeLockerPass;
import cleancode.studycafe.tobe.model.pass.StudyCafePassType;
import cleancode.studycafe.tobe.model.pass.StudyCafeSeatPass;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class StudyCafePassOrderTest {

  @DisplayName("주문한 이용권과 사물함 가격을 더하고 할인율을 적용한 총 결제 금액을 구한다.")
  @Test
  void OrderTotalPrice() {

    //시간권 given
    StudyCafeSeatPass studyCafeSeatPassHourly = StudyCafeSeatPass.of(StudyCafePassType.HOURLY, 4, 10000, 0);
    StudyCafeLockerPass lockerPasHourly = null;

    StudyCafePassOrder orderHourly = StudyCafePassOrder.of(studyCafeSeatPassHourly, lockerPasHourly);

    // when
    int totalPriceHourly = orderHourly.getTotalPrice();

    // then
    assertThat(totalPriceHourly).isEqualTo(10000);


    // 주간권 given
    StudyCafeSeatPass studyCafeSeatPassWeekly = StudyCafeSeatPass.of(StudyCafePassType.WEEKLY, 8, 30000, 0);
    StudyCafeLockerPass lockerPassWeekly = null;

    StudyCafePassOrder orderWeekly = StudyCafePassOrder.of(studyCafeSeatPassWeekly, lockerPassWeekly);

    // when
    int totalPriceWeekly = orderWeekly.getTotalPrice();

    // then
    assertThat(totalPriceWeekly).isEqualTo(30000);


    // 고정권 given
    StudyCafeSeatPass studyCafeSeatPassFixed = StudyCafeSeatPass.of(StudyCafePassType.FIXED, 2, 250000, 0.5);
    StudyCafeLockerPass lockerPassFixed = StudyCafeLockerPass.of(StudyCafePassType.FIXED, 2, 20000);

    StudyCafePassOrder orderFixed = StudyCafePassOrder.of(studyCafeSeatPassFixed, lockerPassFixed);


    // when
    int totalPriceFixed = orderFixed.getTotalPrice();

    // then
    assertThat(totalPriceFixed).isEqualTo(145000);
  }
}
