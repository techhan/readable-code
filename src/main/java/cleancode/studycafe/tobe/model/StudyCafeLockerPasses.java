package cleancode.studycafe.tobe.model;

import java.util.List;
import java.util.Optional;

public class StudyCafeLockerPasses {

  private final List<StudyCafeLockerPass> lockerPasses;

  public StudyCafeLockerPasses(List<StudyCafeLockerPass> passes) {
    this.lockerPasses = passes;
  }

  public static StudyCafeLockerPasses of(List<StudyCafeLockerPass> lockerPasses) {
    return new StudyCafeLockerPasses(lockerPasses);
  }

  public Optional<StudyCafeLockerPass> findLockerPassBy(StudyCafePass pass) {
    return this.lockerPasses.stream()
      .filter(pass::isSameDurationType)
      .findFirst();
  }
}
