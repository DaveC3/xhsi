/**
 * CmdSubcomponent.java
 *
 * Copyright (C) 2007  Georg Gruetter (gruetter@gmail.com)
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
 */

package net.sourceforge.xhsi.flightdeck.command;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.Transparency;
import java.awt.image.BufferedImage;

import net.sourceforge.xhsi.XHSIPreferences;
import net.sourceforge.xhsi.model.Aircraft;
import net.sourceforge.xhsi.model.AircraftEnvironment;
import net.sourceforge.xhsi.model.Avionics;
import net.sourceforge.xhsi.model.FMS;
import net.sourceforge.xhsi.model.ModelFactory;
import net.sourceforge.xhsi.model.TCAS;
import net.sourceforge.xhsi.flightdeck.Subcomponent;


public abstract class CmdSubcomponent extends Subcomponent {

    CmdGraphicsConfig cmd_gc;

    public CmdSubcomponent(ModelFactory model_factory, CmdGraphicsConfig cmd_gc) {
        super(model_factory, cmd_gc);
        this.cmd_gc = cmd_gc;
        this.model_factory = model_factory;
        this.aircraft = this.model_factory.get_aircraft_instance();
        this.avionics = this.aircraft.get_avionics();
        this.aircraft_environment = this.aircraft.get_environment();
        this.fms = this.avionics.get_fms();
        this.tcas = this.avionics.get_tcas();
        this.preferences = XHSIPreferences.get_instance();
        this.parent_component = null;

    }

    public CmdSubcomponent(ModelFactory model_factory, CmdGraphicsConfig cmd_gc, Component parent_component) {
        this(model_factory, cmd_gc);
        this.parent_component = parent_component;
    }

    public abstract void paint(Graphics2D g2);
}
