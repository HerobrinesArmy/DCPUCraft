package com.herobrinesarmy.dcpucraft.emulation;

public class LWJGLKeyMapping extends KeyMapping {
   public LWJGLKeyMapping(boolean useLowercase) {
      // TODO Find more keycodes?
      // backspace
      map(14, 0x10);
      // return
      map(28, 0x11);
      // insert No Type
      map(210, 0x12);
      // delete
      map(211, 0x13);
      // ASCII 0x20-0x7F
      map(57, 0x20);
      map(40, 0x27);
      map(51, 0x2C);
      map(12, 0x2D);map(147, 0x2D);
      map(52, 0x2E);
      map(53, 0x2F);
      map(11, 0x30);
      map(2, 0x31);
      map(3, 0x32);map(145, 0x32);
      map(4, 0x33);
      map(5, 0x34);
      map(6, 0x35);
      map(7, 0x36);map(144, 0x36);
      map(8, 0x37);
      map(9, 0x38);
      map(10, 0x39);

      map(39, 0x3B);map(146, 0x3B);

      map(13, 0x3D);
      // Note: Notch uses lowercase characters for key codes, but many in the community seem to prefer uppercase
      // The specification for Generic Keyboard (compatible) doesn't specify which to use. TODO Make it an option.
      map(30, 0x61 - (useLowercase ? 0 : 0x20));
      map(48, 0x62 - (useLowercase ? 0 : 0x20));
      map(46, 0x63 - (useLowercase ? 0 : 0x20));
      map(32, 0x64 - (useLowercase ? 0 : 0x20));
      map(18, 0x65 - (useLowercase ? 0 : 0x20));
      map(33, 0x66 - (useLowercase ? 0 : 0x20));
      map(34, 0x67 - (useLowercase ? 0 : 0x20));
      map(35, 0x68 - (useLowercase ? 0 : 0x20));
      map(23, 0x69 - (useLowercase ? 0 : 0x20));
      map(36, 0x6A - (useLowercase ? 0 : 0x20));
      map(37, 0x6B - (useLowercase ? 0 : 0x20));
      map(38, 0x6C - (useLowercase ? 0 : 0x20));
      map(50, 0x6D - (useLowercase ? 0 : 0x20));
      map(49, 0x6E - (useLowercase ? 0 : 0x20));
      map(24, 0x6F - (useLowercase ? 0 : 0x20));
      map(25, 0x70 - (useLowercase ? 0 : 0x20));
      map(16, 0x71 - (useLowercase ? 0 : 0x20));
      map(19, 0x72 - (useLowercase ? 0 : 0x20));
      map(31, 0x73 - (useLowercase ? 0 : 0x20));
      map(20, 0x74 - (useLowercase ? 0 : 0x20));
      map(22, 0x75 - (useLowercase ? 0 : 0x20));
      map(47, 0x76 - (useLowercase ? 0 : 0x20));
      map(17, 0x77 - (useLowercase ? 0 : 0x20));
      map(45, 0x78 - (useLowercase ? 0 : 0x20));
      map(21, 0x79 - (useLowercase ? 0 : 0x20));
      map(44, 0x7A - (useLowercase ? 0 : 0x20));
      map(26, 0x5B);
      map(43, 0x5C);
      map(27, 0x5D);

      map(41, 0x60);

      // Already mapped to 0x13
      // map(0x7F, 0x7F);

      // Arrow up No Type
      map(200, 0x80);
      // Arrow down No Type
      map(208, 0x81);
      // Arrow left No Type
      map(203, 0x82);
      // Arrow right No Type
      map(205, 0x83);
      // Shift No Type
      map(42, 0x90); //left
      map(54, 0x90); //right
      // Control No Type
      map(29, 0x91); //left
      map(157, 0x91); //right

      // NUMPAD - NUMLOCK ON
      map(82, 0x30); // 0
      map(79, 0x31); // 1
      map(80, 0x32); // 2
      map(81, 0x33); // 3
      map(75, 0x34); // 4
      map(76, 0x35); // 5
      map(77, 0x36); // 6
      map(71, 0x37); // 7
      map(72, 0x38); // 8
      map(73, 0x39); // 9
      map(55, 0x2A); // *
      map(78, 0x2B); // +
      map(74, 0x2D); // -
      map(83, 0x2E); // .
      map(181, 0x2F); // /

      // map(32, 32);
      //
      // map(38, 128);
      // map(40, 129);
      // map(37, 130);
      // map(39, 131);
      //
      // map(10, 17);
      // map(8, 16);
      // map(155, 18);
      // map(127, 19);
      //
      // map(16, 144);
      // map(17, 145);
      // map(18, 145);
      // map(65406, 145);
      //
      // map(49, 49);
      // map(50, 50);
      // map(51, 51);
      // map(52, 52);
      // map(53, 53);
      // map(54, 54);
      // map(55, 55);
      // map(56, 56);
      // map(57, 57);
      // map(48, 48);
      //
      // map(81, 113);
      // map(87, 119);
      // map(69, 101);
      // map(82, 114);
      // map(84, 116);
      // map(89, 121);
      // map(85, 117);
      // map(73, 105);
      // map(79, 111);
      // map(80, 112);
      //
      // map(65, 97);
      // map(83, 115);
      // map(68, 100);
      // map(70, 102);
      // map(71, 103);
      // map(72, 104);
      // map(74, 106);
      // map(75, 107);
      // map(76, 108);
      //
      // map(90, 122);
      // map(88, 120);
      // map(67, 99);
      // map(86, 118);
      // map(66, 98);
      // map(78, 110);
      // map(77, 109);
   }
}
