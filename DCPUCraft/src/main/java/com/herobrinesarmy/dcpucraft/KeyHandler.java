package com.herobrinesarmy.dcpucraft;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;

import org.apache.logging.log4j.Level;
import org.lwjgl.input.Keyboard;

import com.herobrinesarmy.dcpucraft.emulation.VirtualKeyboard;

import cpw.mods.fml.common.FMLLog;

public class KeyHandler implements Runnable // note that before we extended KeyHandler, but that class no longer exists
{
   public static KeyHandler instance = new KeyHandler();
   
   public boolean keyState[] = new boolean[256];
   private HashSet<VirtualKeyboard> keyboards = new HashSet<VirtualKeyboard>();
   private HashMap<Integer, Character> chars = new LinkedHashMap<Integer, Character>();
   private HashMap<Integer, Character> shiftChars = new LinkedHashMap<Integer, Character>();
   private Thread thread;
   private boolean keepAlive = true;
   
   private KeyHandler() {
      setupChars();
      thread = new Thread(this);
      thread.start();
   }
   
   private void setupChars() {
      chars.put(41, '`');
      chars.put(2, '1');
      chars.put(3, '2');
      chars.put(4, '3');
      chars.put(5, '4');
      chars.put(6, '5');
      chars.put(7, '6');
      chars.put(8, '7');
      chars.put(9, '8');
      chars.put(10, '9');
      chars.put(11, '0');
      chars.put(12, '-');
      chars.put(13, '=');
      chars.put(16, 'q');
      chars.put(17, 'w');
      chars.put(18, 'e');
      chars.put(19, 'r');
      chars.put(20, 't');
      chars.put(21, 'y');
      chars.put(22, 'u');
      chars.put(23, 'i');
      chars.put(24, 'o');
      chars.put(25, 'p');
      chars.put(26, '[');
      chars.put(27, ']');
      chars.put(43, '\\');
      chars.put(30, 'a');
      chars.put(31, 's');
      chars.put(32, 'd');
      chars.put(33, 'f');
      chars.put(34, 'g');
      chars.put(35, 'h');
      chars.put(36, 'j');
      chars.put(37, 'k');
      chars.put(38, 'l');
      chars.put(39, ';');
      chars.put(40, '\'');
      chars.put(144, '^');
      chars.put(145, '@');
      chars.put(146, ':');
      chars.put(147, '_');
      chars.put(44, 'z');
      chars.put(45, 'x');
      chars.put(46, 'c');
      chars.put(47, 'v');
      chars.put(48, 'b');
      chars.put(49, 'n');
      chars.put(50, 'm');
      chars.put(51, ',');
      chars.put(52, '.');
      chars.put(53, '/');
      chars.put(57, ' ');
      chars.put(181, '/');
      chars.put(55, '*');
      chars.put(71, '7');
      chars.put(72, '8');
      chars.put(73, '9');
      chars.put(74, '-');
      chars.put(75, '4');
      chars.put(76, '5');
      chars.put(77, '6');
      chars.put(78, '+');
      chars.put(79, '1');
      chars.put(80, '2');
      chars.put(81, '3');
      chars.put(82, '0');
      chars.put(83, '.');
      
      shiftChars.put(41, '~');
      shiftChars.put(2, '!');
      shiftChars.put(3, '@');
      shiftChars.put(4, '#');
      shiftChars.put(5, '$');
      shiftChars.put(6, '%');
      shiftChars.put(7, '^');
      shiftChars.put(8, '&');
      shiftChars.put(9, '*');
      shiftChars.put(10, '(');
      shiftChars.put(11, ')');
      shiftChars.put(12, '_');
      shiftChars.put(13, '+');
      shiftChars.put(16, 'Q');
      shiftChars.put(17, 'W');
      shiftChars.put(18, 'E');
      shiftChars.put(19, 'R');
      shiftChars.put(20, 'T');
      shiftChars.put(21, 'Y');
      shiftChars.put(22, 'U');
      shiftChars.put(23, 'I');
      shiftChars.put(24, 'O');
      shiftChars.put(25, 'P');
      shiftChars.put(26, '{');
      shiftChars.put(27, '}');
      shiftChars.put(43, '|');
      shiftChars.put(30, 'A');
      shiftChars.put(31, 'S');
      shiftChars.put(32, 'D');
      shiftChars.put(33, 'F');
      shiftChars.put(34, 'G');
      shiftChars.put(35, 'H');
      shiftChars.put(36, 'J');
      shiftChars.put(37, 'K');
      shiftChars.put(38, 'L');
      shiftChars.put(39, ':');
      shiftChars.put(40, '"');
      shiftChars.put(144, '^');
      shiftChars.put(145, '@');
      shiftChars.put(146, ':');
      shiftChars.put(147, '_');
      shiftChars.put(44, 'Z');
      shiftChars.put(45, 'X');
      shiftChars.put(46, 'C');
      shiftChars.put(47, 'V');
      shiftChars.put(48, 'B');
      shiftChars.put(49, 'N');
      shiftChars.put(50, 'M');
      shiftChars.put(51, '<');
      shiftChars.put(52, '>');
      shiftChars.put(53, '?');
      shiftChars.put(57, ' ');
      shiftChars.put(181, '/');
      shiftChars.put(55, '*');
      shiftChars.put(71, '7');
      shiftChars.put(72, '8');
      shiftChars.put(73, '9');
      shiftChars.put(74, '-');
      shiftChars.put(75, '4');
      shiftChars.put(76, '5');
      shiftChars.put(77, '6');
      shiftChars.put(78, '+');
      shiftChars.put(79, '1');
      shiftChars.put(80, '2');
      shiftChars.put(81, '3');
      shiftChars.put(82, '0');
      shiftChars.put(83, '.');
   }

   @Override
   public void run() {
      while (keepAlive) //TODO kill it
      {
         updateKeys();
         try {
            Thread.sleep(16);
         } catch (InterruptedException e) {
            e.printStackTrace();
         }
      }
   }

   private void updateKeys() {
//      FMLLog.getLogger().log(Level.DEBUG, "updateKeys");
      for (int i = 0; i < 256; i++)
      {
         boolean down = Keyboard.isKeyDown(i);
         if (down && !keyState[i])
         {
            pressed(i);
         }
         else if (!down && keyState[i])
         {
            released(i);
            typed(i);
         }
      }
   }

   private void typed(int i) {
//      FMLLog.getLogger().log(Level.DEBUG, "typed " + i);
      char c = ' ';
      if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_RSHIFT))
      {
         if (!shiftChars.containsKey(i))
         {
            return;
         }
         c = shiftChars.get(i);
      }
      else
      {
         if (!chars.containsKey(i))
         {
            return;
         }
         c = chars.get(i);
      }
      FMLLog.getLogger().log(Level.DEBUG, "typed " + c);
      for (VirtualKeyboard vk : keyboards)
      {
         vk.keyTyped(c);
      }
   }

   private void released(int i) {
      FMLLog.getLogger().log(Level.DEBUG, "released " + i);
      keyState[i] = false;
      for (VirtualKeyboard vk : keyboards)
      {
         vk.keyReleased(i);
      }
   }

   private void pressed(int i) {
      FMLLog.getLogger().log(Level.DEBUG, "pressed " + i);
      keyState[i] = true;
      for (VirtualKeyboard vk : keyboards)
      {
         vk.keyPressed(i);
      }
   }

   public void registerKeyboard(VirtualKeyboard virtualKeyboard) {
      FMLLog.getLogger().log(Level.DEBUG, "registerKeyboard");
      keyboards.add(virtualKeyboard);
   }
   
   public void unregisterKeyboard(VirtualKeyboard virtualKeyboard) {
      keyboards.remove(virtualKeyboard);
   }
   
//   private final KeyBinding[] keys;
//
//   public KeyHandler() {
//      keys = new KeyBinding[256];
//      for (int i = 0; i < 256; ++i) {
//         keys[i] = new KeyBinding(""+i, i, "key.tutorial.category");
//         ClientRegistry.registerKeyBinding(keys[i]);
//      }
//   }
//
//   /**
//   * KeyInputEvent is in the FML package, so we must register to the FML event bus
//   */
//   @SubscribeEvent
//   public void onKeyInput(KeyInputEvent event) {
//      if (Keyboard.getEventKeyState()) //down
//      {
//         FMLLog.getLogger().log(Level.DEBUG, "Key " + Keyboard.getEventKey() + " '" + Keyboard.getEventCharacter() + "' down");
//      }
//      else //up
//      {
//         FMLLog.getLogger().log(Level.DEBUG, "Key " + Keyboard.getEventKey() + " '" + Keyboard.getEventCharacter() + "' up");
//      }
//   }
}