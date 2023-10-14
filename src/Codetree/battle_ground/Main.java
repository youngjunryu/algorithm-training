package Codetree.battle_ground;

import java.util.*;
import java.io.*;

public class Main {
  static class Person {
    int x;
    int y;
    int init;
    int d;
    Pair gun;
    int point;

    public Person(int x, int y, int init, int d) {
      this.x = x;
      this.y = y;
      this.init = init;
      this.d = d;
      this.gun = null;
      this.point = 0;
    }
  }

  static class Pair implements Comparable<Pair> {
    int strength;

    public Pair(int strength) {
      this.strength = strength;
    }

    @Override
    public int compareTo(Pair p) {
      return p.strength - this.strength;
    }
  }

  static int n; // 격자 크기
  static int m; // 플레이어 수
  static int k; // 라운드 수
  static PriorityQueue<Pair>[][] map;
  static Person[] people;
  static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}}; // 0: 상, 1: 우, 2: 하, 3: 좌

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());

    map = new PriorityQueue[n][n];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int strength = Integer.parseInt(st.nextToken());
        if (strength != 0) pq.add(new Pair(strength));
        map[i][j] = pq;
      }
    }

    people = new Person[m];
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      int d = Integer.parseInt(st.nextToken());
      int s = Integer.parseInt(st.nextToken());
      people[i] = new Person(x - 1, y - 1, s, d);
    }

    while (k-- > 0) {
      move();
    }

    for (int i = 0; i < m; i++) {
      Person p = people[i];
      System.out.print(p.point + " ");
    }
  }

  static void move() {
    for (int i = 0; i < m; i++) {
      Person person = people[i];

      // 한 칸 이동
      int nx = person.x + dir[person.d][0];
      int ny = person.y + dir[person.d][1];

      if (nx < 0 || ny < 0 || nx >= n || ny >= n) { // 격자를 벗어나는 경우
        int d = (person.d + 2) % 4;
        person.d = d;
        nx = person.x + dir[person.d][0];
        ny = person.y + dir[person.d][1];
        person.x = nx;
        person.y = ny;
      } else {
        person.x = nx;
        person.y = ny;
      }

      Person any = null;
      for (int j = 0; j < m; j++) {
        if (i == j) continue;
        Person p = people[j];
        if (p.x == person.x && p.y == person.y) any = p;
      }

      if (any == null) { // 이동한 방향에 플레이어가 없다.
        if (!map[person.x][person.y].isEmpty()) { // 총이 있는 경우
          Pair gun = map[person.x][person.y].poll();
          if (person.gun == null) { // 플레이어가 총이 없는 경우
            person.gun = gun;
          } else {
            if (person.gun.strength < gun.strength) { // 총을 비교하고 획득한다. 나머지 총들은 격자에 둔다.
              Pair personGun = person.gun;
               map[person.x][person.y].add(personGun);
              person.gun = gun;
            } else {
              map[person.x][person.y].add(gun);
            }
          }
        }
      } else { // 이동한 방향에 플레이어가 있다면 싸운다.
        int personStrength = person.init;
        int anyStrength = any.init;

        if (person.gun != null) personStrength += person.gun.strength;
        if (any.gun != null) anyStrength += any.gun.strength;

        int answer = 0;
        if (personStrength > anyStrength) {
          answer = 1;
        } else if (personStrength < anyStrength) {
          answer = 2;
        } else {
          answer = person.init > any.init ? 1 : 2;
        }

        Person winner = null;
        Person loser = null;
        if (answer == 1) { // person 이겼다면 == 움직인 사람이 이겼다면
          winner = person;
          loser = any;
        } else { // any가 이겼다면 == 기존에 있던 사람이 이겼다면
          winner = any;
          loser = person;
        }

        winner.point += Math.abs(personStrength - anyStrength);

        // 진 사람
        if (loser.gun != null) {
          map[loser.x][loser.y].add(loser.gun);
          loser.gun = null;
        }

        while (true) {
          nx = loser.x + dir[loser.d][0];
          ny = loser.y + dir[loser.d][1];

          any = null;
          for (int j = 0; j < m; j++) {
            Person p = people[j];
            if (p.x == nx && p.y == ny)
              any = p;
          }

          if (any != null || nx < 0 || ny < 0 || nx >= n || ny >= n) { // 격자를 벗어나는 경우
            int d = (loser.d + 1) % 4;
            loser.d = d;
          } else {
            loser.x = nx;
            loser.y = ny;
            break;
          }
        }

        if (!map[loser.x][loser.y].isEmpty()) {
          loser.gun = map[loser.x][loser.y].poll();
        }

        // 이긴 사람
        if (!map[winner.x][winner.y].isEmpty()) {
          Pair gun = map[winner.x][winner.y].poll();
          if (winner.gun == null) { // 플레이어가 총이 없는 경우
            winner.gun = gun;
          } else {
            if (winner.gun.strength < gun.strength) { // 총을 비교하고 획득한다. 나머지 총들은 격자에 둔다.
              Pair winnerGun = winner.gun;
              map[winner.x][winner.y].add(winnerGun);
              winner.gun = gun;
            } else {
              map[winner.x][winner.y].add(gun);
            }
          }
        }
      }
    }
  }
}