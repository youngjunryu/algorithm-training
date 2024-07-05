package Baekjoon._20006;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    int p = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    LinkedList<Room> rooms = new LinkedList<>();
    for (int i = 0; i < p; i++) {
      st = new StringTokenizer(br.readLine());
      int level = Integer.parseInt(st.nextToken());
      String name = st.nextToken();

      boolean flag = false;

      if (rooms.isEmpty()) {
        Room room = new Room(new Guest(level, name));
        if (room.guests.size() == m) {
          room.isFull = true;
        }
        rooms.add(room);
        continue;
      }

      for (Room room : rooms) {
        if (!room.isFull && (room.start <= level && room.end >= level)) {
          Guest guest = new Guest(level, name);
          room.guests.add(guest);

          if (room.guests.size() == m) {
            room.isFull = true;
          }

          flag = true;
          break;
        }
      }

      if (!flag) {
        Room room = new Room(new Guest(level, name));
        if (room.guests.size() == m) {
          room.isFull = true;
        }
        rooms.add(room);
      }
    }

    for (Room room : rooms) {
      if (room.isFull) {
        room.print("Started!");
      } else {
        room.print("Waiting!");
      }
    }
  }

  static class Guest implements Comparable<Guest> {

    int level;
    String name;

    public Guest(int level, String name) {
      this.level = level;
      this.name = name;
    }

    @Override
    public int compareTo(Guest o) {
      return this.name.compareTo(o.name);
    }
  }

  static class Room {

    int start;
    int end;
    LinkedList<Guest> guests = new LinkedList<>();
    boolean isFull = false;

    public Room(Guest guest) {
      this.guests.add(guest);
      this.start = guest.level - 10;
      this.end = guest.level + 10;
    }

    public void print(String desc) {
      Collections.sort(this.guests);
      System.out.println(desc);
      for (Guest guest : this.guests) {
        System.out.println(guest.level + " " + guest.name);
      }
    }
  }
}
