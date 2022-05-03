package com.example.readdata.temi;
import android.util.Log;
import com.robotemi.sdk.Robot;
import com.robotemi.sdk.TtsRequest;
import com.robotemi.sdk.listeners.OnGoToLocationStatusChangedListener;
import org.jetbrains.annotations.NotNull;
import java.util.List;
/*
  extends : 정의된 객체를 상속받았을 경우 해당 기능을 연장해서 사용한다는 뜻이다.

  implements : abstract 객체를 상속받고 그 내용들을 작성했다는 뜻이다.
              abstract 클래스의 경우 필수 기능의 메서드의 형태만 정의되어있기때문에
              상세 내용을 override를 통해서 반드시 정의해야하며 , 부모늬 클래스는 작성된 내용이 없기때문에
              super를 통하여 부모의 기능을 실핼 수 없다.
*/
public class RoboTemiListeners extends RoboTemi implements OnGoToLocationStatusChangedListener{
    private Robot robot;

    public RoboTemiListeners() {
        // this: 현재 객체를 가르킨다.
        // 같은 변수가 있을 경우 this는 class 전역을, 일반 변수는 괄호 내의 변수를 뜻한다.
        this.robot =  Robot.getInstance();
    }

    public void init(){
        robot.addOnGoToLocationStatusChangedListener(this);
    }
    public void stop(){
        robot.removeOnGoToLocationStatusChangedListener(this);
    }
    @Override
    public void onGoToLocationStatusChanged(String location, String status, int descriptionId, String description) {

        switch (status) {
            case "start":
                robot.speak(TtsRequest.create("Starting", false));
                break;

            case "calculating":
                robot.speak(TtsRequest.create("Calculating", false));
                break;

            case "going":
                robot.speak(TtsRequest.create("Going", false));
                break;

            case "complete":
                robot.speak(TtsRequest.create("Completed", false));
                break;

            case "abort":
                robot.speak(TtsRequest.create("Cancelled", false));
                break;
        }
    }
}
