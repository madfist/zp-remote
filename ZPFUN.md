# ZoomPlayer Functions
## Standard Functions
These are simple functions that perform a specific function without any additional information required such as Play and Pause.

No.|Function|Mode|Description
---|---|---|---
000|fnPlay|All|Starts playback and toggles between Play & Pause states.
001|fnPause|All|Pauses video and frame advances when already paused.
002|fnStop|Media|Stops playback and goes to the beginning of the video.
|| |DVD|Stops playback and closes DVD.
003|fnStopToFirst|Media|Stop to First Item in a Playlist.
004|fnNextChapter|Media|Go to Next Chapter (Internal or OGM), if no chapters are specified, advance to the next item in the Playlist.
|| |DVD|Open the Next Bookmark.
005|fnPrevChapter|Media|Go to Previous Chapter (Internal or OGM), if no chapters are specified, go back to the previous item in the Playlist.
|| |DVD|Open the Previous Bookmark.
006|fnNextTrack|Media|Go to the Next item on the Playlist
|| |DVD|Go to the Next Chapter.
007|fnPrevTrack|Media|Go to the Previous item on the Playlist.
|| |DVD|Go to the Next Chapter.
008|fnNextFrame|All|Frame Step Forward.
009|fnPrevFrame|All|Frame Step Backward.
010|fnNextVid|Media|Play the Next Video in the current folder.
011|fnPrevVid|Media|Play the Previous Video in the current folder.
012|fnSkipForward|All|Short seek forward a specified number of seconds (default 5sec).
013|fnSkipBackward|All|Short seek backward a specified number of seconds (default 5sec).
014|fnJumpForward|All|Medium seek forward a specified number of seconds (default 20sec).
015|fnJumpBackward|All|Medium seek backward a specified number of seconds (default 20sec).
016|fnSeekForward|All|Long seek forward a specified number of seconds (default 120sec = 2 minutes).
017|fnSeekBackward|All|Long seek backward a specified number of seconds (default 120sec = 2 minutes).
018|fnFastForward|All|Play in Fast Forward.
019|fnRewind|All|Rewind Playback.
020|fnSlowMotion|All|Play in Slow Motion.
021|fnHalfFF|All|Half Fast forward speed.
022|fnHalfSM|All|Half Slow Motion speed.
023|fnVolUp|All|Increase Volume.
024|fnVolDown|All|Decrease Volume.
025|fnMute|All|Mute Volume (ON/OFF).
026|fnABRepeat|All|Start, Stop and Cancel AB-Repeat.
027|fnPlayEndCycle|All|Cycle through the "On Play Complete" values.
028|fnZoomAxis|All|Toggles the Zoom Axis (used with Zoom-In / Zoom-Out).
029|fnZoomIn|All|Zoom into video (enlarge video area).
030|fnZoomOut|All|Zoom out of video (shrink video area).
031|fnZoomInWidth|All|Stretch the video width.
032|fnZoomOutWidth|All|Shrink the video width.
033|fnZoomInHeight|All|Stretch the video height.
034|fnZoomOutHeight|All|Shrink the video height.
035|fnZoom|All|Go into Zoom Mode.
036|fnFullScreen|All|Go Into Fullscreen Mode.
037|fnFitSource|All|Resize video area to the original video source size.
038|fnMax|All|Maximize user interface to cover work area or if in fullscreen maximize video area to cover screen.
039|fnMinimize|All|Minimize the user interface.
040|fnARCycle|All|Cycle through Aspect Ratio modes.
041|fnRevARCycle|All|Reverse Cycle through Aspect Ratio modes.
042|fnBar|All|Show / Hide the Control Bar.
043|fnOSD|All|Turn the On Screen Display ON / OFF.
044|fnOpen|All|Open File(s) for playback.
045|fnOpenDir|All|Open a Folder for playback.
046|fnInfo|All|Playback Information Dialog (some information on the playing media).
047|fnOptions|All|Open the Options Dialog.
048|fnPresets|All|Open the Video Position Preset Dialog.
049|fnPlayList|All|Show / Hide the Playlist Editor.
050|fnChapter|Media|Show / Hide the Chapter Editor.
|| |DVD|Show / Hide the Bookmark Editor.
051|fnSkin|All|Show / Hide the Skin Selection dialog.
052|fnKeyHelp|All|Opens the Keyboard Shortcut Dialog (key list).
053|fnExit|All|Exit application.
054|fnAddChapter|Media|Add Current Position to the Chapter Editor.
|| |DVD|Save Current Position as a Bookmark.
055|fnSaveChapter|Media|Save Chapter List.
056|fnDVDMode|All|Switch between the Media and DVD Modes.
057|fnDVDRootMenu|DVD|Go to the DVD's Root Menu.
058|fnDVDTitleMenu|DVD|Go to the DVD's Title Menu.
059|fnDVDSubMenu|DVD|Go to the DVD's Subtitle Menu.
060|fnDVDAudioMenu|DVD|Go to the DVD's Audio Menu.
061|fnDVDAngleMenu|DVD|Go to the DVD's Angle Menu.
062|fnDVDChapterMenu|DVD|Go to the DVD's Chapter Menu.
063|fnDVDMenuLeft|DVD|Move left on a DVD Menu.
064|fnDVDMenuRight|DVD|Move right on a DVD Menu.
065|fnDVDMenuUp|DVD|Move up on a DVD Menu.
066|fnDVDMenuDown|DVD|Move down on a DVD Menu.
067|fnDVDMenuSelect|DVD|Activate selected DVD Menu item.
068|fnDVDCC|All|Closed Captions ON / OFF.
069|fnDVDAngle|Media|Cycle through OGM Video Tracks.
|| |DVD|Cycle through DVD Angles.
070|fnDVDSub|Media|Cycle through VobSub/OGM Subtitle Tracks.
|| |DVD|Cycle through DVD Subtitle Tracks.
071|fnAudioTrack|Media|Cycle through Media Audio Tracks.
|| |DVD|Cycle through DVD Audio Tracks.
072|fnStayOnTop|All|Stay On Top ON / OFF.
073|fnMPEG4|All|MPEG4/DivX/Video Decoder Dialog (if filter is in use).
074|fnSub|All|Open the Subtitle configuration dialog.
075|fnAudioFilter|All|TFM/DeDynamic Audio Filter Dialog (if filter is in use).
076|fnIncRate|All|Increase Play rate.
077|fnDecRate|All|Decrease Play rate.
078|fnPrevFilterFile|None|Previous Manual Filter File ** disabled **
079|fnNextFilterFile|None|Next Manual Filter File ** disabled **
080|fnSaveDF|All|Save Definition File for the currently open media.
081|fnFrameCapture|All|Screenshot / Frame Capture.
082|fnPattern|All|Cycle Pattern Modes.
083|fnEject|All|Eject the specified CD drive.
084|fnOverlayControl|All|Show / Hide the Color Control Interface.
085|fnOverlayApply|All|Apply the Color Controls (same as button in options).
086|fnOverlayReset|All|Reset the Color Controls back to their default settings.
087|fnIncBrightness|All|Increase Brightness.
088|fnDecBrightness|All|Decrease Brightness.
089|fnIncContrast|All|Increase Contrast.
090|fnDecContrast|All|Decrease Contrast.
091|fnIncGamma|All|Increase Gamma.
092|fnDecGamma|All|Decrease Gamma.
093|fnIncHue|All|Increase Hue.
094|fnDecHue|All|Decrease Hue.
095|fnIncSaturation|All|Increase Saturation.
096|fnDecSaturation|All|Decrease Saturation.
097|fnUnpause|All|Unpause the video (Discrete Play).
098|fnAddALBookmark|DVD|Add DVD Auto-Load Bookmark.
099|fnSeekToStart|All|Seek to start of Video.
100|fnAudioDecoder|All|Pop the property dialog of filters with "Audio Decoder" in their titles.
101|fnDVDMenuPrev|DVD|Return from DVD Sub-Menu. If on Top Menu then Resume playback.
102|fnChapterNav|Media|Show / Hide the Chapter Navigator dialog.
|| |DVD|Show / Hide the Bookmark Navigator dialog.
103|fnPlayListNav|All|Show / Hide the Playlist Navigator dialog.
104|fnFileNav|All|Show / Hide the File Navigator dialog.
105|fnBlankingNav|All|Show / Hide the Blanking Navigator dialog.
106|fnBlankingPreset|All|Show / Hide the Blanking Presets dialog.
107|fnBlanking|All|Show / Hide Video Blanking.
108|fnRandomPlay|Media|Turns Random (shuffle) Play ON / OFF.
109|fnResizeNav|All|Show / Hide the Resize Navigator dialog.
110|fnDisableDVDSub|Media|Disable (hide) Subtitle display.
|| |DVD|Disable DVD Subtitle.
111|fnPresetCycle|All|Cycle through Video Position Presets.
112|fnRevPresetCycle|All|Reverse Cycle through Video Position Presets.
113|fnBlankCycle|All|Cycle through Blanking Position Presets.
114|fnRevBlankCycle|All|Reverse Cycle through Blanking Position Presets.
115|fnDVDPlayStart|DVD|Play DVD bypassing Auto-Bookmark loading features.
116|fnNextArrowFunc|All|Next Active Arrow Control function.
117|fnPrevArrowFunc|All|Previous Active Arrow Control function.
118|fnAutoARToggle|DVD|Enable / Disable Automatic DVD Aspect Ratio.
119|fnFrameZeroALBM|DVD|Attempt setting a DVD Auto-Load bookmark at frame zero.
120|fnPauseAtEOF|Media|Pause Playback at end of currently playing file.
121|fnSceneCut|All|Show / Hide the Scene Cut Editor.
122|fnGoTo|All|Show / Hide the GoTo Timeline dialog.
123|fnGoToNav|All|Show / Hide the GoTo Timeline Navigator interface.
124|fnMWFuncNav|All|Show / Hide the Mouse Wheel Function Navigator interface.
125|fnLoop|Media|Switch between Do Nothing and Auto Reply on Play Complete.
126|fnBalanceLeft|All|Move Audio Balance to the Left.
127|fnBalanceRight|All|Move Audio Balance to the Right.
128|fnOpenDrive|All|Open an entire drive.
129|fnMediaNav|All|Show / Hide the Media Library Navigator.
130|fnMediaPathEdit|All|Show / Hide the Media Library Path and Category Editor.
131|fnSrcRelStretch|All|Enable / Disable Source Relative User Interface Stretch.
132|fnZoom50|All|Set video to default to 50%.
133|fnZoom100|All|Set video to default to 100%.
134|fnZoom200|All|Set video to default to 200%.
135|fnZoom400|All|Set video to default to 400%.
136|fnZoom800|All|Set video to default to 800%.
137|fnWebNav|All|Show / Hide the Web URL Navigator.
138|fnBringToFront|All|Bring Player Window to Front.
139|fnLoopPlay|Media|Enable / Disable looping of currently playing track.
140|fnPLAddFiles|All|Add Files to Playlist.
141|fnPLAddDir|All|Add Folder to Playlist.
142|fnPLRemove|All|Remove Selected Items from Playlist.
143|fnPLClear|All|Clear the entire Playlist.
144|fnPLLoadList|All|Load a Playlist.
145|fnPLSaveList|All|Save the Playlist.
146|fnPLSort|All|Sort the Playlist Items.
147|fnPLItemUp|All|Move Selected Playlist Items Up.
148|fnPLItemDown|All|Move Selected Playlist Items Down.
149|fnPLMax|All|Maximize the Playlist Window.
150|fnLoadDF|All|Load Definition File for the currently open media.
151|fnRadioManager|Media|Show/Hide the Station Manager Dialog.
152|fnContextNav|All|Show/Hide the Context Navigator.
153|fnPlayHistory|Media|Show/Hide the Play History Interface.
154|fnPLGetDuration|Media|Get Duration of Media Files in the current Playlist.
155|fnEqualizer|All|Show/Hide the Internal Equalizer Window.
156|fnEQEditor|All|Show/Hide the Equalizer Profile Selector/Editor.
157|fnEQReset|All|Reset the current Equalizer Values.
158|fnEQToggle|All|Enable/Disable the Equalizer.
159|fnResyncAhead|All|Resynchronize Audio Ahead.
160|fnResyncBack|All|Resynchronize Audio Back.
161|fnFastPlay|Media|Fast Playback with Audio.
162|fnVobSubSelect|All|DirectVobSub Subtitle File Selection.
163|fnOpenURL|All|Open URL.
164|fnAudioMode|Media|Switch to Audio only mode (no video area) skin.
165|fnSSaverToggle|All|Internal Screen Saver Toggle.
166|fnTVMode|None|Not implemented.
167|fnSpace|All|Call the user-selected Space function.
168|fnIncHeight|All|Increase Height 1 Pixel.
169|fnDecHeight|All|Decrease Height 1 Pixel.
170|fnIncWidth|All|Increase Width 1 Pixel.
171|fnDecWidth|All|Decrease Width 1 Pixel.
172|fnDummy|All|Does nothing, useful for skinning.
173|fnSceneCutToggle|All|Enable/Disable the Scene Cut feature.
174|fnStationNav|All|Show/Hide the Station Navigator.
175|fnVidLeft|All|Move Video Position to the Left.
176|fnVidRight|All|Move Video Position to the Right.
177|fnVidUp|All|Move Video Position Upwards.
178|fnVidDown|All|Move Video Position Downwards.
179|fnPLItemDir|All|Open the folder of the currently highlighted item in the Playlist.
180|fnDateTime|All|OSD-Popup of the current Date & Time.
181|fnSubSyncAhead|Media|(Only with DirectVobSub) Resynch Subtitles Ahead 100ms.
182|fnSubSyncBack|Media|(Only with DirectVobSub) Resynch Subtitles Back 100ms.
183|fnSubUp|Media|(Only with DirectVobSub) Move Subtitles Up 1 percent.
184|fnSubDown|Media|(Only with DirectVobSub) Move Subtitles Down 1 percent.
185|fnPLControl|All|Open/Close the Playlist Control interface.
186|fnPLMagToggle|All|Toggle the Playlist Editor's Magnetic Docking.
187|fnEQMagToggle|All|Toggle the Equalizer's Magnetic Docking.
188|fnIncPreAmp|All|Increase PreAmp Volume.
189|fnDecPreAmp|All|Decrease PreAmp Volume.
190|fnMainNav|All|Show/Hide the Main Navigator.
191|fnLibCategoryNav|All|Show/Hide the Media Library Category Navigator.
192|fnPrevDirFileExt|Media|Play Previous file in the folder with the same File Extension.
193|fnNextDirFileExt|Media|Play Next file in the folder with the same File Extension.
194|fnCBarButToggle|All|Show/Hide the Control Bar Buttons.
195|fnDeleteCurrent|Media|Delete the Currently Playing file.
196|fnPLtoTop|All|Move selected Playlist items to top of list.
197|fnPLtoBottom|All|Move selected Playlist items to bottom of list.
198|fnEQNav|All|Show/Hide the Equalizer Navigator.
199|fnPlayHistoryNav|All|Show/Hide the Play History Navigator.
200|fnCloseNavs|All|Close All Navigators.
201|fnLastNav|All|Open/Close the last open navigator.
202|fnPrevDVDTitle|DVD|Go to Previous DVD Title.
203|fnNextDVDTitle|DVD|Go to Next DVD Title.
204|fnContactSheet|Media|Open the Contact Sheet dialog.
205|fnReloadCurrent|Media|Reload the currently open media file.
206|fnBlankMonitors|All|Blank (cover with a black window) non-Active monitors.
207|fnFSActMonitor|All|Fullscreen on active monitor.
208|fnDownloadNav|All|Download Manager Navigator (show/hide).
209|fnPosToClipboard|All|Copy the current position to the Windows Clipboard.
210|fnInfoNav|All|Information Navigator (show/hide).
211|fnSaveFileAs|All|Save currently playing file.
212|fnDoSearch|All|Unused at this time.
213|fnSearchList|All|Unused at this time.
214|fnDeInterlace|All|DeInterlace Video (enabled/disabled).
215|fnSharpen|All|Sharpen Video (enabled/disabled).
216|fnOpenWebPage|All|Open Web Page Dialog.
217|fnRingTone|All|Create a RingTone from a playing media section.
218|fnZoomTo43Wide|All|Zoom on badly encoded 16:9 content (encoded with black bars).
219|fnVolumeWindow|All|Pop-up the Volume-Slider Window.
220|fnWhiteWash|All|WhiteWash Screen-Burn repair.
221|fnResetWindows|All|Reset user interface windows to their default location.
222|fnIncRateEx|All|Increase Play Rate by a user specified value.
223|fnDecRateEx|All|Decrease Play Rate by a user specified value.
224|fnZoomInLevel|All|Cycle Zoom-in Levels (16.6%, 33.3%, 50%, 100%).
225|fnSkinSelectNav|All|Fullscreen navigation skin selection navigator (show/hide).
226|fnResetBright|All|Reset Brightness to default value.
227|fnResetContrast|All|Reset Contrast to default value.
228|fnResetGamma|All|Reset Gamma to default value.
229|fnResetHue|All|Reset Hue to default value.
230|fnResetSatur|All|Reset Saturation to default value.
231|fnRandDirMedia|Media|Random play a media file from the playing folder.
232|fnRandDirFileExt|Media|Random play a file with the same extension from the playing folder.
233|fnSeekLongForward|All|Long seek forward a specified number of seconds (default 600 seconds = 10 minutes).
234|fnSeekLongBackward|All|Long seek backward a specified number of seconds (default 600 seconds = 10 minutes).
235|fnMainContextMenu|All|Pop-up the Main Context Menu.
236|fnPLContextMenu|All|Pop-up the Playlist Context Menu.
237|fnResetBalance|All|Reset the Audio Balance to Center.
238|fnResetPlayRate|Media|Reset Play Rate to normal speed.
239|fnIncDerivedAR|All|Manually increase Derived Aspect Ratio width.
240|fnDecDerivedAR|All|Manually decrease Derived Aspect Ratio width.
241|fnScheduler|All|Show/Hide the Schedule editor.
242|fnRename|Media|Rename/Move the playing media or selected playlist entry.
243|fnMadVRSmoothMo|All|Enable/Disable MadVR's smooth motion.
244|fnAutoPlayNext|Media|Enable/Disable Auto-Play next file in the playlist.
245|fnRotateVideo|All|Rotate the video in 90 degree increments.
246|fnFileAssociation|All|Show the file format association dialog.
247|fnDSZoomIn|All|DirectShow Zoom-in (only works for DirectShow based playback and may not work with all video renderers).
248|fnDSZoomOut|All|DirectShow Zoom-out (only works for DirectShow based playback and may not work with all video renderers).
249|fnDSPanLeft|All|DirectShow Pan-left (only works for DirectShow based playback and may not work with all video renderers).
250|fnDSPanRight|All|DirectShow Pan-right (only works for DirectShow based playback and may not work with all video renderers).
251|fnDSPanUp|All|DirectShow Pan-up (only works for DirectShow based playback and may not work with all video renderers).
252|fnDSPanDown|All|DirectShow Pan-down (only works for DirectShow based playback and may not work with all video renderers).
253|fnPLEditMetaData|All|Open meta-data editor for the currently playing media or playlist selected media.
254|fnPLAddUrl|All|Add a media streaming URL (link) to the playlist.
255|fnLockUI|All|Lock the user interface.
256|fnPreConfigPCType|All|Open the PC/HTPC/Tablet configuration wizard.
257|fnMediaScannerNav|All|Show / Hide the Media Scanner Navigator dialog.
258|fnStreamSelectNav|All|Show / Hide the Stream Selection Navigator dialog.
259|fnThumbViewMiniMenu|All|Show/Hide ThumbView mode's Mini-Menu.
260|fnPSTogglePreSize|All|Toggle ON/OFF pre-image resize Pixel Shaders.
261|fnPSTogglePostSize|All|Toggle ON/OFF post-image resize Pixel Shaders.
262|fnPSToggleBoth|All|Toggle ON/OFF pre and post-image resize Pixel Shaders.
263|fnToggleTAGDisplay|All|Toggle ON/OFF audio TAGs display.
264|fnPlayingToClipboard|All|Copies the currently playing media file/URL to the clipboard.
265|fnSubSearchPlaying|All|Subtitle search for the playing video.
266|fnSubSearchDialog|All|Subtitle search for a video file.
267|fnOpenClipboardURL|All|Open URL from Clipboard.
268|fnScreenSaver|All|Activate internal screen saver.
269|fnPathToClipboard|All|Copy playing media path to Clipboard.
270|fnOpenStreamInBrowser|All|Open playing stream in the default web browser.
271|fnPLEraseFiles|All|Play next media track after erasing the playing track
272|fnToggleSub|All|Toggle subtitle display (show/hide)
273|fnTitleToClipboard|All|Copy the media's title to the Clipboard
274|fnWMPActiveX|All|Stream Windows media content using Windows Media Player ActiveX (enabled/disabled)
275|fnMediaSrcToClipboard|All|Copy the media (file or url) from the DirectShow source filter to the clipboard

## Extended Functions
Unlike the regular functions, extended functions pass an additional parameter to the function. 

No.|Function|Description|Value
---|---|---|---
000|exSetAR|Set Aspect Ratio|0-6
001|exApplyPR|Apply Zoom Preset|0-9
002|exSavePR|Save Zoom Preset|0-9
003|exChapterTrack|Chapter/Track Selector|0-9 (Opens chapter/track dialog with 5 seconds timeout for a second key)
004|exBlanking|Set Blanking Preset|0-9 (Automatically enables blanking)
005|exSetMode|Set Playback Mode|0-Media Mode, 1-DVD Mode, 2-Audio Mode
006|exInterface|Toggle Interfaces|00-Show Control Bar<br>01-Hide Control Bar<br>02-Show Playlist Editor<br>03-Hide Playlist Editor<br>04-Show Chapter/Bookmark Editor<br>05-Hide Chapter/Bookmark Editor<br>06-Set Windowed Mode<br>07-Set Zoom Mode<br>08-Set Fullscreen Mode<br>09-Show Equalizer<br>10-Hide Equalizer<br>11-Enable Pop-up OSD messages<br>12-Disable Pop-up OSD messages<br>13-Show the Station Manager<br>14-Hide the Station Manager
007|exSetPlayRate|Set Media Play Rate|1-22670 (where 10000 = Standard Play)
008|exSetCustomAR|Set Custom Aspect Ratio|0-9 (Automatically switches AR to Custom mode)
009|exOverlayColor|Set Color Control Preset|0-9
010|exPlayComplete|Set Playlist Complete Mode|00-Do Nothing<br>01-Auto Rewind<br>02-Auto Replay<br>03-Close Player<br>04-Shutdown Windows<br>05-Play Next Dir File (Media Ext)<br>06-Minimize<br>07-Eject CD<br>08-Close Media<br>09-Open Media Library<br>10-Randomize & Replay<br>11-Play Next Dir File (Same Ext)
011|exDVDNumPad|Select DVD Number Pad|0-9
012|exOpenDrive|Open an entire drive|0-25 (0 = A:, 2 = C: ... 25 = Z:)
013|exSeekAhead|Seek Ahead [n] Seconds|1-999999999
014|exSeekBack|Seek Back [n] Seconds|1-999999999
015|exSeekTo|Seek to Position [n] Seconds|0-999999999
016|exGroupToggle|Toggle Skin Groups|0-1^32 (Bitmask indicating which groups to toggle, use a negative value to force the window size to remain unchanged)
017|exGroupEnable|Enable Skin Groups|0-1^32 (Bitmask indicating which groups to enable, use a negative value to force the window size to remain unchanged)
018|exGroupDisable|Disable Skin Groups|0-1^32 (Bitmask indicating which groups to disable, use a negative value to force the window size to remain unchanged)
019|exGroupSet|Set the Skin Groups Mask|0-1^32 (Bitmask indicating the group mask, use a negative value to force the window size to remain unchanged)
020|exSetVolume|Set the Audio Volume|0-100 (Percentage of volume level)
021|exEjectDrive|Eject/Insert a drive|0-25 (drives A-Z where 0=A and 25=Z)
022|exEnableTCP|Enable TCP/IP interface|TCP Port number
023|exZoomTo|Zoom Video Size (percent)|1-1000 Zoom Video Size (percent)
024|exTransWin|Set player Window Transparency|1-255, where 255 = disable transparency
025|exRandomPlay|Set Random Play ON/OFF|0=Off, 1=On
026|exSkinTint|Set the User Interface color Tint|RGB Integer Value (Example: "$FF0000" = Red)
027|exSkinMode|Enable Skin-Specific Mode|1-6, by default assigned to F4-F9 keys
028|exScheduler|Enable/Disable the Scheduler|0 = Disable the scheduler, 1 = Enable the scheduler
029|exPlaylistMode|Sets the 'on playlist complete' mode|0 = Do nothing<br>1 = Auto-Rewind<br>2 = Auto-Replay<br>3 = Close Player<br>4 = Shutdown Windows<br>5 = Play Next dir file (media ext)<br>6 = Minimize<br>7 = Eject CD<br>8 = Close Media<br>9 = Open Media Library<br>10 = Randomize Playlist & Replay<br>11 = Play Next dir file (same ext)<br>12 = Play Next Random dir file (media ext)<br>13= Play Next Random dir file (same ext)
030|exPartLoader|Set the Multiple-Part file loader mode|0 = Disable the Multi-Part loader<br>1 = Set Multi-Part file loader to Automatic Match<br>2 = Set Multi-Part file loader to Name Masking
031|exStayOnTop|Set 'Stay on Top' mode|0 = Disable Stay on Top<br>1 = Enable Stay on Top
032|exSlideshow|Set image slideshow duration|The number of seconds to display a still image, set to 0 to disable the slideshow feature.
033|exFastforward|Fast Forward|A value of 2500 = x2.5 fast forward rate, a positive value specifies an on/off toggle, a negative value (-2500) indicates the new value should be applied even if fast forward is already active.
034|exRewind|Rewind|A value of 2500 = x2.5 rewind rate, a positive value specifies an on/off toggle, a negative value (-2500) indicates the new value should be applied even if rewind is already active.
035|exSlowMotion|Slow Motion|A value of 500 = x0.5 slow motion rate, a positive value specifies an on/off toggle, a negative value (-500) indicates the new value should be applied even if slow motion is already active.
036|exDirectShowZoom|DirectShow Zoom|A value of 10000-1000000 (only works for DirectShow based playback and may not work with all video renderers).
037|exDirectShowPan|DirectShow Pan|A value of 0-10000 (only works for DirectShow based playback and may not work with all video renderers).
038|exLAVHWAccel|LAV Hardware Acceleration|0 = Use LAV's setting<br>1 = None (software decoding)<br>2 = NVIDIA CUVID<br>3 = Intel® QuickSync<br>4 = DXVA2 (copy-back)<br>5 = DXVA2 (native)
039|exPSPreset|Apply Pixel Shader preset|1-100 (requires using MadVR as the video renderer and pixel shaders presets created through the advanced options dialog
040|exSeekAheadPercent|Seek Ahead (percent of duration)|0-100000, A value of 10000 = seek ahead 10%
041|exSeekBackPercent|Seek Back (percent of duration)|0-100000, A value of 10000 = seek back 10%
042|exSeekToPercent|Seek To (percent of duration)|0-100000, A value of 50000 = seek to 50%
043|exWMPActiveX|Directly set whether Windows media content streaming will use Windows Media Player's ActiveX control|0=Disabled<br>1=Enabled

## Navigator Functions
Navigation functions are used to control the Fullscreen Navigation interfaces. 

No.|Function|Description
---|---|---
000|nvLeft|Navigate Left
001|nvRight|Navigate Right
002|nvUp|Navigate Up
003|nvDown|Navigate Down
004|nvHome|Navigate to Top
005|nvEnd|Navigate to Bottom
006|nvPgUp|Navigate a Page Up
007|nvPgDn|Navigate a Page Down
008|nvSelect|Select/Activate
009|nvInsert|Insert/Add
010|nvDelete|Delete
011|nvBackspace|Back
012|nvEscape|Escape/Close
013|nvShift|Toggle SHIFT state
014|nvCAPSLOCK|Toggle CAPSLOCK state