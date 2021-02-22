package com.company;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public interface PageStructure {
    void setMyLayout();
    void allContainer();
    void setLayoutMan ();
    Border lightGray = BorderFactory.createLineBorder(Color.LIGHT_GRAY, 3, true);
    Border border = BorderFactory.createRaisedBevelBorder();


}
