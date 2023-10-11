import java.util.*;

public class Notebook {

  int memory;
  int hdd;
  String os;
  String colour;

  static Map <Integer, Integer> fillMemories (Map <Integer, Integer> memories) {
    memories.put(1, 8);
    memories.put(2, 16);
    memories.put(3, 32);
    return memories;
  }

  static Map <Integer, Integer> fillHdds (Map <Integer, Integer> hdds) {
    hdds.put(1, 512);
    hdds.put(2, 1024);
    return hdds;
  }

  static Map <Integer, String> fillOss (Map <Integer, String> oss) {
    oss.put(1, "Windows 11");
    oss.put(2, "FreeDos");
    oss.put(3, "Ubuntu");
    return oss;
  }

  static Map <Integer, String> fillColours (Map <Integer, String> colours) {
    colours.put(1, "black");
    colours.put(2, "silver");
    colours.put(3, "white");
    return colours;
  }

  static Notebook generateNotebook (Map <Integer, Integer> memories, Map <Integer, Integer> hdds, Map <Integer, String> oss, Map <Integer, String> colours) {
    Notebook q = new Notebook();
    Random random = new Random();
    Object [] value = memories.values().toArray();

    int index = random.nextInt(memories.size());
    q.memory = memories.get(index);
    index = random.nextInt(hdds.size());
    q.hdd = hdds.get(index);
    index = random.nextInt(oss.size());
    q.os = oss.get(index);
    index = random.nextInt(colours.size());
    q.colour = colours.get(index);
    return q;
  }

  @Override
  public String toString() {
    return ("Memory: " + memory + "Gb, " + "HDD: " + hdd + "Gb, " + "Операционная система: " + os + "Цвет: " + colour);
  }
}
