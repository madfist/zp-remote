package com.madfist.zpremote.controller;

import java.util.Locale;

/**
 * Created by akoleszar on 2017.10.03..
 */

public final class MessageCode {
    ///Messages from ZoomPlayer
    public final static int APPLICATION_NAME = 0;
    public final static int VERSION = 1;
    public final static int PING = 100;
    public final static int SYSTEM_TIME = 110;
    public final static int MONITOR_LAYOUT = 120;
    public final static int AVAILABLE_AUDIO_DEVICES = 130;
    public final static int NEW_AUDIO_DEVICE = 132;
    public final static int CURRENT_AUDIO_DEVICE = 134;
    public final static int NEW_VIDEO_RENDERER = 142;
    public final static int CURRENT_VIDEO_RENDERER = 144;
    public final static int MOUSE_CURSOR_STATE = 150;
    public final static int WRONG_PASSWORD = 201;
    public final static int STATE_CHANGE = 1000;
    public final static int CURRENT_FULLSCREEN_STATE = 1010;
    public final static int CURRENT_FASTFORWARD_STATE = 1020;
    public final static int CURRENT_REWIND_STATE = 1021;
    public final static int TIMELINE_TEXT = 1090;
    public final static int POSITION_UPDATE = 1100;
    public final static int CURRENT_DURATION = 1110;
    public final static int CURRENT_POSITION = 1120;
    public final static int CURRENT_FRAMERATE = 1130;
    public final static int ESTIMATED_FRAMERATE = 1140;
    public final static int OSD_MESSAGE = 1200;
    public final static int OSD_MESSAGE_OFF = 1201;
    public final static int CURRENT_PLAY_MODE = 1300;
    public final static int TV_PC_MODE = 1310;
    public final static int DVD_TITLE_CHANGE = 1400;
    public final static int DVD_TITLE_COUNT = 1401;
    public final static int DVD_DOMAIN_CHANGE = 1410;
    public final static int DVD_MENU_MODE = 1420;
    public final static int DVD_UNIQUE_STRING = 1450;
    public final static int DVD_CHAPTER_CHANGE = 1500;
    public final static int DVD_CHAPTER_COUNT = 1501;
    public final static int DVD_MEDIA_ACTIVE_AUDIO_TRACK = 1600;
    public final static int DVD_MEDIA_AUDIO_TRACK_COUNT = 1601;
    public final static int DVD_AUDIO_NAMES = 1602;
    public final static int AUDIO_TRACK_CHANGED = 1605;
    public final static int DVD_MEDIA_ACTIVE_SUB = 1700;
    public final static int DVD_MEDIA_SUB_COUNT = 1701;
    public final static int DVD_MEDIA_SUB_NAMES = 1702;
    public final static int DVD_SUB_DISABLED = 1704;
    public final static int SUBTITLE_TRACK_CHANGED = 1705;
    public final static int DVD_ANGLE_CHANGE = 1750;
    public final static int DVD_ANGLE_COUNT = 1751;
    public final static int CURRENTLY_LOADED_FILE = 1800;
    public final static int CURRENT_PLAYLIST = 1810;
    public final static int PLAYLIST_COUNT_CHANGED = 1811;
    public final static int END_OF_FILE = 1855;
    public final static int FILE_PLAYLIST_POSITION = 1900;
    public final static int PLAYLIST_CLEARED_ACK = 1920;
    public final static int PLAYLIST_ITEM_WAS_REMOVED = 1950;
    public final static int VIDEO_RESOLUTION = 2000;
    public final static int VIDEO_FRAME_RATE = 2100;
    public final static int ASPECT_RATIO_CHANGE = 2200;
    public final static int DVD_AR_MODE_CHANGE = 2210;
    public final static int AUDIO_VOLUME = 2300;
    public final static int MEDIA_CONTENT_TAGS = 2400;
    public final static int CD_DVD_INSERTED = 2500;
    public final static int VIDEO_DISPLAY_AREA_X_OFFSET = 2611;
    public final static int VIDEO_DISPLAY_AREA_Y_OFFSET = 2621;
    public final static int VIDEO_DISPLAY_AREA_WIDTH = 2631;
    public final static int VIDEO_DISPLAY_AREA_HEIGHT = 2641;
    public final static int PLAY_RATE_CHANGED = 2700;
    public final static int RANDOM_PLAY_STATE = 2710;
    public final static int ZP_ERROR_MESSAGE = 3000;
    public final static int NAV_DIALOG_OPENED = 3100;
    public final static int NAV_DIALOG_CLOSED = 3110;
    public final static int SCREEN_SAVER_MODE = 3200;
    public final static int VIRTUAL_KEYBOARD_INPUT_RESULT = 4000;
    public final static int ZP_FUNCTION_CALLED = 5100;
    public final static int ZP_EXFUNCTION_CALLED = 5110;
    public final static int ZP_SCANCODE_CALLED = 5220;
    public final static int SHARED_ITEMS_LIST = 6000;
    public final static int ADD_SHARED_ITEMS_ACK = 6010;
    public final static int PLAYLIST_SAVED_ACK = 6020;
    public final static int PLAYLIST_FILE_CONTENT = 6030;
    public final static int CURRENT_PLAYLIST_CONTENT = 6040;
    public final static int SCHEDULED_MEDIA_ABOUT_TO_START = 6100;
    public final static int SCHEDULED_MEDIA_HAS_ENDED = 6101;
    public final static int CURRENT_SCHEDULE_STATE = 6110;
    public final static int CURRENT_SCHEDULE_LIST = 6120;
    public final static int NUMBER_OF_SCHEDULE_ENTRIES_SET = 6130;
    public final static int CURRENT_SCHEDULE_PAUSE_STATE = 6140;
    public final static int CURRENT_SCHEDULE_UI_STATE = 6150;
    public final static int FLASH_MOUSE_CLICK = 9000;
    ///Messages to ZoomPlayer
    public final static int GET_APPLICATION_NAME = APPLICATION_NAME;
    public final static int GET_VERSION = VERSION;
    public final static int GET_SYSTEM_TIME = SYSTEM_TIME;
    public final static int GET_MONITOR_LAYOUT = MONITOR_LAYOUT;
    public final static int GET_AVAILABLE_AUDIO_DEVICES = AVAILABLE_AUDIO_DEVICES;
    public final static int SET_ACTIVE_AUDIO_DEVICE = NEW_AUDIO_DEVICE;
    public final static int GET_CURRENT_AUDIO_DEVICE = CURRENT_AUDIO_DEVICE;
    public final static int SET_ACTIVE_VIDEO_RENDERER = NEW_VIDEO_RENDERER;
    public final static int GET_CURRENT_VIDEO_RENDERER = CURRENT_VIDEO_RENDERER;
    public final static int SHOW_HIDE_MOUSE_CURSOR = MOUSE_CURSOR_STATE;
    public final static int GET_PLAY_STATE = STATE_CHANGE;
    public final static int GET_FULLSCREEN_STATE = CURRENT_FULLSCREEN_STATE;
    public final static int SET_ON_TOP_STATE = 1040;
    public final static int GET_TIMELINE_TEXT = TIMELINE_TEXT;
    public final static int SET_TIMELINE_UPDATES = POSITION_UPDATE;
    public final static int GET_CURRENT_DURATION = CURRENT_DURATION;
    public final static int GET_CURRENT_POSITION = CURRENT_POSITION;
    public final static int GET_CURRENT_FRAMERATE = CURRENT_FRAMERATE;
    public final static int GET_ESTIMATED_FRAMERATE = ESTIMATED_FRAMERATE;
    public final static int SHOW_OSD_MESSAGE = OSD_MESSAGE;
    public final static int HIDE_OSD_MESSAGE = OSD_MESSAGE_OFF;
    public final static int OSD_MESSAGE_ON = 1202;
    public final static int OSD_MESSAGE_DISPLAY_DURATION = 1210;
    public final static int GET_CURRENT_PLAY_MODE = CURRENT_PLAY_MODE;
    public final static int GET_DVD_TITLE = DVD_TITLE_CHANGE;
    public final static int GET_DVD_TITLE_COUNT = DVD_TITLE_COUNT;
    public final static int GET_DVD_MENU_MODE = DVD_MENU_MODE;
    public final static int GET_DVD_UNIQUE_STRING = DVD_UNIQUE_STRING;
    public final static int GET_DVD_CHAPTER = DVD_CHAPTER_CHANGE;
    public final static int GET_DVD_CHAPTER_COUNT = DVD_CHAPTER_COUNT;
    public final static int GET_DVD_MEDIA_ACTIVE_AUDIO_TRACK = DVD_MEDIA_ACTIVE_AUDIO_TRACK;
    public final static int GET_DVD_MEDIA_AUDIO_TRACK_COUNT = DVD_MEDIA_AUDIO_TRACK_COUNT;
    public final static int GET_DVD_AUDIO_NAMES = DVD_AUDIO_NAMES;
    public final static int SET_AUDIO_TRACK = 1603;
    public final static int GET_DVD_MEDIA_ACTIVE_SUB = DVD_MEDIA_ACTIVE_SUB;
    public final static int GET_DVD_MEDIA_SUB_COUNT = DVD_MEDIA_SUB_COUNT;
    public final static int GET_DVD_MEDIA_SUB_NAMES = DVD_MEDIA_SUB_NAMES;
    public final static int SET_SUBTITLE_TRACK = 1703;
    public final static int HIDE_SUBTITLES = DVD_SUB_DISABLED;
    public final static int GET_DVD_ANGLE = DVD_ANGLE_CHANGE;
    public final static int GET_DVD_ANGLE_COUNT = DVD_ANGLE_COUNT;
    public final static int SET_DVD_ANGLE = 1753;
    public final static int GET_CURRENTLY_LOADED_FILE = CURRENTLY_LOADED_FILE;
    public final static int GET_CURRENT_PLAYLIST = CURRENT_PLAYLIST;
    public final static int GET_PLAYLIST_COUNT = PLAYLIST_COUNT_CHANGED;
    public final static int PLAY_MEDIA_FILE = 1850;
    public final static int CLOSE_MEDIA_FILE = 1852;
    public final static int BROWSE_WEB = 1860;
    public final static int GET_PLAYLIST_INDEX = FILE_PLAYLIST_POSITION;
    public final static int SET_PLAYLIST_INDEX = 1910;
    public final static int CLEAR_PLAYLIST = PLAYLIST_CLEARED_ACK;
    public final static int ADD_PLAYLIST_FILE = 1930;
    public final static int ADD_PLAYLIST_FILE_AND_PLAY = 1935;
    public final static int SELECT_PLAYLIST_ITEM = 1940;
    public final static int DESELECT_PLAYLIST_ITEM = 1941;
    public final static int REMOVE_PLAYLIST_ITEM = PLAYLIST_ITEM_WAS_REMOVED;
    public final static int GET_ASPECT_RATIO_MODE = ASPECT_RATIO_CHANGE;
    public final static int GET_DVD_AR_MODE = DVD_AR_MODE_CHANGE;
    public final static int GET_AUDIO_VOLUME = AUDIO_VOLUME;
    public final static int SET_AUDIO_VOLUME = 2310;
    public final static int SET_DERIVED_MODE_AR = 2600;
    public final static int SET_VIDEO_DISPLAY_AREA_X_OFFSET = 2610;
    public final static int GET_VIDEO_DISPLAY_AREA_X_OFFSET = VIDEO_DISPLAY_AREA_X_OFFSET;
    public final static int SET_VIDEO_DISPLAY_AREA_Y_OFFSET = 2620;
    public final static int GET_VIDEO_DISPLAY_AREA_Y_OFFSET = VIDEO_DISPLAY_AREA_Y_OFFSET;
    public final static int SET_VIDEO_DISPLAY_AREA_WIDTH = 2630;
    public final static int GET_VIDEO_DISPLAY_AREA_WIDTH = VIDEO_DISPLAY_AREA_WIDTH;
    public final static int SET_VIDEO_DISPLAY_AREA_HEIGHT = 2640;
    public final static int GET_VIDEO_DISPLAY_AREA_HEIGHT = VIDEO_DISPLAY_AREA_HEIGHT;
    public final static int SET_PLAYER_WINDOW_DIMENSIONS = 2650;
    public final static int SET_PLAYER_ON_TOP_VALUE = 2660;
    public final static int SET_FULLSCREEN_MONITOR = 2670;
    public final static int GET_PLAYRATE = PLAY_RATE_CHANGED;
    public final static int SET_PLAYRATE = 2701;
    public final static int GET_RANDOM_PLAY_STATE = RANDOM_PLAY_STATE;
    public final static int DISMISS_ZP_ERROR = ZP_ERROR_MESSAGE;
    public final static int VIRTUAL_KEYBOARD_INPUT_QUERY = VIRTUAL_KEYBOARD_INPUT_RESULT;
    public final static int SET_CURRENT_POSITION = 5000;
    public final static int PLAY_DVD_TITLE = 5010;
    public final static int PLAY_DVD_TITLE_CHAPTER = 5020;
    public final static int PLAY_DVD_CHAPTER = 5030;
    public final static int CALL_ZP_FUNCTION = ZP_FUNCTION_CALLED;
    public final static int CALL_ZP_EXFUNCTION = ZP_EXFUNCTION_CALLED;
    public final static int CALL_ZP_SCANCODE = ZP_SCANCODE_CALLED;
    public final static int CALL_ZP_NVFUNCTION = 5130;
    public final static int LIST_SHARED_ITEMS = SHARED_ITEMS_LIST;
    public final static int ADD_SHARED_ITEMS_TO_PLAYLIST = ADD_SHARED_ITEMS_ACK;
    public final static int SAVE_PLAYLIST = PLAYLIST_SAVED_ACK;
    public final static int GET_PLAYLIST_FILE_CONTENT = PLAYLIST_FILE_CONTENT;
    public final static int GET_CURRENT_PLAYLIST_CONTENT = CURRENT_PLAYLIST_CONTENT;
    public final static int SET_SCHEDULE_STATE = 6105;
    public final static int GET_CURRENT_SCHEDULE_STATE = CURRENT_SCHEDULE_STATE;
    public final static int GET_CURRENT_SCHEDULE_LISR = CURRENT_SCHEDULE_LIST;
    public final static int SET_NEW_SCHEDULE_LIST = NUMBER_OF_SCHEDULE_ENTRIES_SET;

    public static int parse(String num) {
        return Integer.parseInt(num);
    }

    public static String get(int num) {
        return String.format("%04d", num);
    }

    public static int timeInSeconds(String timeString) {
        String[] units = timeString.split(":");
        return Integer.parseInt(units[0]) * 3600 + Integer.parseInt(units[1]) * 60 + Integer.parseInt(units[2]);
    }

    public static String secondsToTime(int seconds) {
        return String.format(Locale.US, "%02d:%02d:%02d", seconds/3600, (seconds%3600)/60, seconds%60);
    }
}
