package jp.mituliii.hardkeytest;

public enum HTKeyCodeMap
{
  KEYCODE_UNKNOWN ("UNKNOWN", 0),
  KEYCODE_SOFT_LEFT ("SOFT_LEFT", 1),
  KEYCODE_SOFT_RIGHT ("SOFT_RIGHT", 2),
  KEYCODE_HOME ("HOME", 3),
  KEYCODE_BACK ("BACK", 4),
  KEYCODE_CALL ("CALL", 5),
  KEYCODE_ENDCALL ("ENDCALL", 6),
  KEYCODE_0 ("0", 7),
  KEYCODE_1 ("1", 8),
  KEYCODE_2 ("2", 9),
  KEYCODE_3 ("3", 10),
  KEYCODE_4 ("4", 11),
  KEYCODE_5 ("5", 12),
  KEYCODE_6 ("6", 13),
  KEYCODE_7 ("7", 14),
  KEYCODE_8 ("8", 15),
  KEYCODE_9 ("9", 16),
  KEYCODE_STAR ("STAR", 17),
  KEYCODE_POUND ("POUND", 18),
  KEYCODE_DPAD_UP ("DPAD_UP", 19),
  KEYCODE_DPAD_DOWN ("DPAD_DOWN", 20),
  KEYCODE_DPAD_LEFT ("DPAD_LEFT", 21),
  KEYCODE_DPAD_RIGHT ("DPAD_RIGHT", 22),
  KEYCODE_DPAD_CENTER ("DPAD_CENTER", 23),
  KEYCODE_VOLUME_UP ("VOLUME_UP", 24),
  KEYCODE_VOLUME_DOWN ("VOLUME_DOWN", 25),
  KEYCODE_POWER ("POWER", 26),
  KEYCODE_CAMERA ("CAMERA", 27),
  KEYCODE_CLEAR ("CLEAR", 28),
  KEYCODE_A ("A", 29),
  KEYCODE_B ("B", 30),
  KEYCODE_C ("C", 31),
  KEYCODE_D ("D", 32),
  KEYCODE_E ("E", 33),
  KEYCODE_F ("F", 34),
  KEYCODE_G ("G", 35),
  KEYCODE_H ("H", 36),
  KEYCODE_I ("I", 37),
  KEYCODE_J ("J", 38),
  KEYCODE_K ("K", 39),
  KEYCODE_L ("L", 40),
  KEYCODE_M ("M", 41),
  KEYCODE_N ("N", 42),
  KEYCODE_O ("O", 43),
  KEYCODE_P ("P", 44),
  KEYCODE_Q ("Q", 45),
  KEYCODE_R ("R", 46),
  KEYCODE_S ("S", 47),
  KEYCODE_T ("T", 48),
  KEYCODE_U ("U", 49),
  KEYCODE_V ("V", 50),
  KEYCODE_W ("W", 51),
  KEYCODE_X ("X", 52),
  KEYCODE_Y ("Y", 53),
  KEYCODE_Z ("Z", 54),
  KEYCODE_COMMA ("COMMA", 55),
  KEYCODE_PERIOD ("PERIOD", 56),
  KEYCODE_ALT_LEFT ("ALT_LEFT", 57),
  KEYCODE_ALT_RIGHT ("ALT_RIGHT", 58),
  KEYCODE_SHIFT_LEFT ("SHIFT_LEFT", 59),
  KEYCODE_SHIFT_RIGHT ("SHIFT_RIGHT", 60),
  KEYCODE_TAB ("TAB", 61),
  KEYCODE_SPACE ("SPACE", 62),
  KEYCODE_SYM ("SYM", 63),
  KEYCODE_EXPLORER ("EXPLORER", 64),
  KEYCODE_ENVELOPE ("ENVELOPE", 65),
  KEYCODE_ENTER ("ENTER", 66),
  KEYCODE_DEL ("DEL", 67),
  KEYCODE_GRAVE ("GRAVE", 68),
  KEYCODE_MINUS ("MINUS", 69),
  KEYCODE_EQUALS ("EQUALS", 70),
  KEYCODE_LEFT_BRACKET ("LEFT_BRACKET", 71),
  KEYCODE_RIGHT_BRACKET ("RIGHT_BRACKET", 72),
  KEYCODE_BACKSLASH ("BACKSLASH", 73),
  KEYCODE_SEMICOLON ("SEMICOLON", 74),
  KEYCODE_APOSTROPHE ("APOSTROPHE", 75),
  KEYCODE_SLASH ("SLASH", 76),
  KEYCODE_AT ("AT", 77),
  KEYCODE_NUM ("NUM", 78),
  KEYCODE_HEADSETHOOK ("HEADSETHOOK", 79),
  KEYCODE_FOCUS ("FOCUS", 80),
  KEYCODE_PLUS ("PLUS", 81),
  KEYCODE_MENU ("MENU", 82),
  KEYCODE_NOTIFICATION ("NOTIFICATION", 83),
  KEYCODE_SEARCH ("SEARCH", 84),
  KEYCODE_MEDIA_PLAY_PAUSE ("MEDIA_PLAY_PAUSE", 85),
  KEYCODE_MEDIA_STOP ("MEDIA_STOP", 86),
  KEYCODE_MEDIA_NEXT ("MEDIA_NEXT", 87),
  KEYCODE_MEDIA_PREVIOUS ("MEDIA_PREVIOUS", 88),
  KEYCODE_MEDIA_REWIND ("MEDIA_REWIND", 89),
  KEYCODE_MEDIA_FAST_FORWARD ("MEDIA_FAST_FORWARD", 90),
  KEYCODE_MUTE ("MUTE", 91);

  private String name;
  private int    keyCode;

  private HTKeyCodeMap(String name, int keyCode)
  {
    this.name = name;
    this.keyCode = keyCode;
  }

  public String getName()
  {
    return name;
  }

  public int getKeyCode()
  {
    return keyCode;
  }

  public static HTKeyCodeMap valueOf(int keyCode)
  {
    for (HTKeyCodeMap keyCodeMap : values()) {
      if (keyCodeMap.getKeyCode() == keyCode) {
        return keyCodeMap;
      }
    }
    return HTKeyCodeMap.KEYCODE_UNKNOWN;
  }

}