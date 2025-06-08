package cleancode.studycafe.tobe.model.pass;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StudyCafePassTypeTest {

  @DisplayName("이용권 타입에 따라 락커 사용 가능 여부를 반환한다.")
  @Test
  void isLockerUnavailableForPassType() {
    //given
    StudyCafePassType hourly = StudyCafePassType.HOURLY;
    StudyCafePassType weekly = StudyCafePassType.WEEKLY;
    StudyCafePassType fixed  = StudyCafePassType.FIXED;

    // when
    boolean hourlyLocker = hourly.isNotLockerType();
    boolean weeklyLocker = weekly.isNotLockerType();
    boolean fixedLocker = fixed.isNotLockerType();

    // then
    assertThat(hourlyLocker).isTrue();
    assertThat(weeklyLocker).isTrue();
    assertThat(fixedLocker).isFalse();
  }
}
