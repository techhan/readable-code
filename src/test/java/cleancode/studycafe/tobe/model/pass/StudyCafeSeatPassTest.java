package cleancode.studycafe.tobe.model.pass;

import cleancode.studycafe.tobe.model.pass.locker.StudyCafeLockerPass;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class StudyCafeSeatPassTest {

  @DisplayName("입력받은 이용권과 같은 타입인지 비교한다.")
  @Test
  void isSamePassType() {
    //given
    StudyCafePassType passType = StudyCafePassType.HOURLY;
    StudyCafeLockerPass lockerPass = StudyCafeLockerPass.of(passType, 4, 40000);

    //when
    StudyCafePassType passType2 = StudyCafePassType.HOURLY;
    boolean samePassType = lockerPass.isSamePassType(passType2);

    //then
    assertThat(samePassType).isTrue();
  }

  @DisplayName("입력받은 이용권과 다른 타입인지 비교한다.")
  @Test
  void isNotSamePassType() {
    //given
    StudyCafePassType passType = StudyCafePassType.HOURLY;
    StudyCafeLockerPass lockerPass = StudyCafeLockerPass.of(passType, 4, 40000);

    //when
    StudyCafePassType passType2 = StudyCafePassType.WEEKLY;
    boolean samePassType = lockerPass.isSamePassType(passType2);

    //then
    assertThat(samePassType).isFalse();
  }
}
