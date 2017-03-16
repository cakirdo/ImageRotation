/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import imagerotation.ImageRotation;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author dogan.cakir
 */
public class Test1 {
    int x;
    int y;
    public Test1() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
     x=1;
     y=0;
    }
    
    @After
    public void tearDown() {
    }

    @Test
     public void testx90() {
         assertEquals( 0, (int)ImageRotation.rotatedX(x, y, 90));
     }
     
     @Test
     public void testx180() {
         assertEquals( -1, (int)ImageRotation.rotatedX(x, y, 180));
     }
    @Test
     public void testx270() {
         assertEquals( 0, (int)ImageRotation.rotatedX(x, y, 270));
     }
    @Test
     public void testx360() {
         assertEquals( 1, (int)ImageRotation.rotatedX(x, y, 360));
     }
    @Test
     public void testy90() {
         assertEquals( 1, (int)ImageRotation.rotatedY(x, y, 90));
     }
    @Test
     public void testy180() {
         assertEquals( 0, (int)ImageRotation.rotatedY(x, y, 180));
     }
    @Test
     public void testy270() {
         assertEquals( -1, (int)ImageRotation.rotatedY(x, y, 270));
     }
    @Test
     public void testy360() {
         assertEquals( 0, ImageRotation.rotatedY(x, y, 360),3);
     }
    @Test
     public void testy30() {
         assertEquals( 0.866, ImageRotation.rotatedY(x, y, 30),3);
     }
     @Test
     public void testx60() {
         assertEquals( 0.866, ImageRotation.rotatedX(x, y, 60),3);
     }
     @Test
     public void testy60() {
         assertEquals( 0.5, ImageRotation.rotatedY(x, y, 60),1);
     }
     @Test
     public void testx30() {
         assertEquals( 0.5, ImageRotation.rotatedX(x, y, 30),1);
     }
      @Test
     public void testx45() {
         assertEquals( 0.707, ImageRotation.rotatedX(x, y, 45),3);
     }
     @Test
     public void testy45() {
         assertEquals( 0.707, ImageRotation.rotatedY(x, y, 45),3);
     } 
}
