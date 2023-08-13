package Archiving.PROGRAMMERS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class 주차_요금_계산 {
  HashMap<String, Car> cars;
  ArrayList<String> parking;

  public int[] solution(int[] fees, String[] records) {
    cars = new HashMap<>();
    parking = new ArrayList<>();

    for (String record : records) {
      String[] s = record.split(" ");

      if (!cars.containsKey(s[1])) {
        cars.put(s[1], new Car(s[1]));
      }

      if (s[2].equals("IN")) {
        parking.add(s[1]);
        Car car = cars.get(s[1]);
        car.setTime(s[0]);
      } else if (s[2].equals("OUT")) {
        parking.remove(s[1]);
        Car car = cars.get(s[1]);
        addTime(car, s[0]);
      }
    }

    if (!parking.isEmpty()) {
      for (String num : parking) {
        Car car = cars.get(num);
        addTime(car, "23:59");
      }
    }

    return chargeFee(fees);
  }

  private int[] chargeFee(int[] fees) {
    List<String> keyList = new ArrayList<>(cars.keySet());
    keyList.sort((s1, s2) -> s1.compareTo(s2));

    int[] answer = new int[keyList.size()];

    for (int i = 0; i < keyList.size(); i++) {
      int fee = fees[1];
      Car car = cars.get(keyList.get(i));
      if (car.sum <= fees[0]) {
        answer[i] = fee;
      } else {
        if ((car.sum - fees[0]) % fees[2] > 0) {
          fee += ((car.sum - fees[0]) / fees[2] + 1) * fees[3];
        } else {
          fee += ((car.sum - fees[0]) / fees[2]) * fees[3];
        }

        answer[i] = fee;
      }
    }

    return answer;
  }

  private void addTime(Car car, String e) {
    int sum = 0;
    String[] start = car.time.split(":");
    int startHour = Integer.parseInt(start[0]);
    int startMin = Integer.parseInt(start[1]);

    String[] end = e.split(":");
    int endHour = Integer.parseInt(end[0]);
    int endMin = Integer.parseInt(end[1]);

    if (endMin >= startMin) {
      sum += (endHour - startHour) * 60 + endMin - startMin;
    } else {
      sum += (endHour - startHour - 1) * 60 + endMin + 60 - startMin;
    }

    car.updateSum(sum);
  }

  class Car {
    String num;
    String time;
    int sum = 0;

    public Car(String num) {
      this.num = num;
    }

    public void setTime(String time) {
      this.time = time;
    }

    public void updateSum(int sum) {
      this.sum += sum;
    }
  }
}
