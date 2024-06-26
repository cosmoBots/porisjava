/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gatATAC.poris.test;

import org.gatATAC.poris.PORISMode;
import org.gatATAC.poris.PORISNode;
import org.gatATAC.poris.PORISValue;
import org.gatATAC.poris.PORISValueFloat;

/**
 *
 * @author osiris
 */
public class GenCode {

    public static PORISNode load() {

        //// Paste here
        PORISNode s498 = new PORISNode("TxTestInstrument");
        s498.setId(498);
        s498.setLabel("Test Instrument");
        PORISNode s499 = new PORISNode("TxMasks");
        s499.setId(499);
        s499.setLabel("Masks");
        PORISValue v503 = new PORISValue("Tx2.0");
        v503.setId(503);
        v503.setLabel("2.0 arcsecs");
        s499.addValue(v503);
        PORISValue v504 = new PORISValue("Tx0.6");
        v504.setId(504);
        v504.setLabel("0.6 arcsecs");
        s499.addValue(v504);
        PORISValue v505 = new PORISValue("Tx1.0");
        v505.setId(505);
        v505.setLabel("1.0 arcsecs");
        s499.addValue(v505);
        PORISMode m519 = new PORISMode("TxMasksAll");
        m519.setId(519);
        m519.setLabel("All");
        m519.addValue(v503);
        m519.addValue(v504);
        m519.addValue(v505);
        m519.setDefaultValue(v503);
        s499.addMode(m519);
        s499.setDefaultMode(m519);
        s498.addSubSystem(s499);
        PORISNode s500 = new PORISNode("TxFilters");
        s500.setId(500);
        s500.setLabel("Filters");
        PORISValue v509 = new PORISValue("TxRed");
        v509.setId(509);
        v509.setLabel("Red");
        s500.addValue(v509);
        PORISValue v510 = new PORISValue("TxBlue");
        v510.setId(510);
        v510.setLabel("Blue");
        s500.addValue(v510);
        PORISMode m521 = new PORISMode("TxFiltersAll");
        m521.setId(521);
        m521.setLabel("All");
        m521.addValue(v509);
        m521.addValue(v510);
        m521.setDefaultValue(v509);
        s500.addMode(m521);
        PORISMode m522 = new PORISMode("TxFiltersNone");
        m522.setId(522);
        m522.setLabel("None");
        s500.addMode(m522);
        s500.setDefaultMode(m521);
        s498.addSubSystem(s500);
        PORISNode s501 = new PORISNode("TxDispersion");
        s501.setId(501);
        s501.setLabel("Dispersion");
        PORISValue v506 = new PORISValue("TxR500");
        v506.setId(506);
        v506.setLabel("R500");
        s501.addValue(v506);
        PORISValue v507 = new PORISValue("TxR1000");
        v507.setId(507);
        v507.setLabel("R1000");
        s501.addValue(v507);
        PORISValue v508 = new PORISValue("TxR2000");
        v508.setId(508);
        v508.setLabel("R2000");
        s501.addValue(v508);
        PORISMode m520 = new PORISMode("TxDispersionAll");
        m520.setId(520);
        m520.setLabel("All");
        m520.addValue(v506);
        m520.addValue(v507);
        m520.addValue(v508);
        m520.setDefaultValue(v506);
        s501.addMode(m520);
        s501.setDefaultMode(m520);
        s498.addSubSystem(s501);
        PORISNode s502 = new PORISNode("TxDetector");
        s502.setId(502);
        s502.setLabel("Detector");
        PORISNode s512 = new PORISNode("TxBinning");
        s512.setId(512);
        s512.setLabel("Binning");
        PORISValue v513 = new PORISValue("Tx1x1");
        v513.setId(513);
        v513.setLabel("1x1");
        s512.addValue(v513);
        PORISValue v514 = new PORISValue("Tx2x1");
        v514.setId(514);
        v514.setLabel("2x1");
        s512.addValue(v514);
        PORISValue v515 = new PORISValue("Tx1x2");
        v515.setId(515);
        v515.setLabel("1x2");
        s512.addValue(v515);
        PORISValue v516 = new PORISValue("Tx2x2");
        v516.setId(516);
        v516.setLabel("2x2");
        s512.addValue(v516);
        PORISMode m523 = new PORISMode("TxBinningAll");
        m523.setId(523);
        m523.setLabel("All");
        m523.addValue(v513);
        m523.addValue(v514);
        m523.addValue(v515);
        m523.addValue(v516);
        m523.setDefaultValue(v513);
        s512.addMode(m523);
        PORISMode m526 = new PORISMode("TxBinningSquare");
        m526.setId(526);
        m526.setLabel("Square");
        m526.addValue(v513);
        m526.addValue(v516);
        m526.setDefaultValue(v513);
        s512.addMode(m526);
        s512.setDefaultMode(m523);
        s502.addSubSystem(s512);
        PORISNode s517 = new PORISNode("TxExpTime");
        s517.setId(517);
        s517.setLabel("Exposure Time");
        PORISValueFloat v518 = new PORISValueFloat("TxExpTimeRange", 0.01, 0.0, 1000.0);
        v518.setId(518);
        s517.addValue(v518);
        PORISMode m524 = new PORISMode("TxExpTimeNormal");
        m524.setId(524);
        m524.setLabel("Normal");
        m524.addValue(v518);
        m524.setDefaultValue(v518);
        s517.addMode(m524);
        s517.setDefaultMode(m524);
        s502.addSubSystem(s517);
        PORISMode m525 = new PORISMode("TxDetectorNormal");
        m525.setId(525);
        m525.setLabel("Normal");
        m525.addSubMode(m523);
        m525.addSubMode(m524);
        m525.setDefaultSubMode(m523);
        s502.addMode(m525);
        PORISMode m527 = new PORISMode("TxDetectorSquareBinning");
        m527.setId(527);
        m527.setLabel("Square Binning");
        m527.addSubMode(m524);
        m527.addSubMode(m526);
        m527.setDefaultSubMode(m524);
        s502.addMode(m527);
        s502.setDefaultMode(m525);
        s498.addSubSystem(s502);
        PORISMode m528 = new PORISMode("TxInstrumentPhotometry");
        m528.setId(528);
        m528.setLabel("Photometry");
        m528.addSubMode(m521);
        m528.addSubMode(m522);
        m528.addSubMode(m525);
        m528.setDefaultSubMode(m521);
        s498.addMode(m528);
        PORISMode m529 = new PORISMode("TxInstrumentSpectroscopy");
        m529.setId(529);
        m529.setLabel("Spectroscopy");
        m529.addSubMode(m519);
        m529.addSubMode(m520);
        m529.addSubMode(m521);
        m529.addSubMode(m522);
        m529.addSubMode(m527);
        m529.setDefaultSubMode(m519);
        s498.addMode(m529);
        s498.setDefaultMode(m528);
        PORISNode s = s498;
        //// End Paste

        return s;
    }
}
