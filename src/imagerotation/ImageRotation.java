/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imagerotation;

import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author dogan.cakir
 */
public class ImageRotation {

    public static double rotatedX(int x,int y,double degree)
    {
        return Math.cos(Math.toRadians(degree))*x-Math.sin(Math.toRadians(degree))*y;
    }
    public static double rotatedY (int x,int y,double degree)
    {       
        return Math.sin(Math.toRadians(degree))*x+Math.cos(Math.toRadians(degree))*y;
    }
    
    public static BufferedImage rotateFromCorner(BufferedImage oldImage,double degree)
    {
        BufferedImage newImage = new BufferedImage(oldImage.getWidth(), oldImage.getHeight(), oldImage.getType());
        for(int i=0;i<newImage.getWidth();i++)
        {
            for(int j=0;j<newImage.getHeight();j++)
            {
                newImage.setRGB(i, j,0);            
            }        
        }
        for(int i=0;i<oldImage.getWidth();i++)
        {
            for(int j=0;j<oldImage.getHeight();j++)
            {
                if(rotatedX(i,j,degree)>=0&&rotatedX(i,j,degree)<newImage.getWidth()&&rotatedY(i,j,degree)>=0&&rotatedY(i,j,degree)<newImage.getHeight())
                newImage.setRGB((int)rotatedX(i,j,degree), (int)rotatedY(i,j,degree),oldImage.getRGB(i, j));            
            }        
        }
        
        
        return newImage;
        
    }
        public static BufferedImage rotateFromCenter(BufferedImage oldImage,double degree)
    {
        BufferedImage newImage = new BufferedImage(oldImage.getWidth(), oldImage.getHeight(), oldImage.getType());
        for(int i=0;i<newImage.getWidth();i++)
        {
            for(int j=0;j<newImage.getHeight();j++)
            {
                newImage.setRGB(i, j,0);            
            }        
        }
        for(int i=0;i<oldImage.getWidth();i++)
        {
            for(int j=0;j<oldImage.getHeight();j++)
            {
                if(rotatedX(i-oldImage.getWidth()/2,j-oldImage.getHeight()/2,degree)+oldImage.getWidth()/2>=0&&rotatedX(i-oldImage.getWidth()/2,j-oldImage.getHeight()/2,degree)+oldImage.getWidth()/2<newImage.getWidth()&&rotatedY(i-oldImage.getWidth()/2,j-oldImage.getHeight()/2,degree)+oldImage.getHeight()/2>=0&&rotatedY(i-oldImage.getWidth()/2,j-oldImage.getHeight()/2,degree)+oldImage.getHeight()/2<newImage.getHeight())
                newImage.setRGB((int)rotatedX(i-oldImage.getWidth()/2,j-oldImage.getHeight()/2,degree)+oldImage.getWidth()/2, (int)rotatedY(i-oldImage.getWidth()/2,j-oldImage.getHeight()/2,degree)+oldImage.getHeight()/2,oldImage.getRGB(i, j));            
            }        
        }
        
        
        return newImage;
        
    }
    
    
    public static void main(String[] args) throws IOException {
        String path="C:\\Users\\dogan.cakir\\Documents\\NetBeansProjects\\ImageRotation\\burdur-golu.jpg";
            BufferedImage img =ImageIO.read(new File(path));
            Scanner in= new Scanner(System.in);
            int degree=in.nextInt(); 
            BufferedImage cornerRotated=rotateFromCorner(img, degree);
            BufferedImage centralRotated=rotateFromCenter(img, degree);
            JFrame frame = new JFrame();
            frame.getContentPane().setLayout(new FlowLayout());
            frame.getContentPane().add(new JLabel(new ImageIcon(img)));
            frame.getContentPane().add(new JLabel(new ImageIcon(cornerRotated)));
            frame.getContentPane().add(new JLabel(new ImageIcon(centralRotated)));
            frame.pack();
            frame.setVisible(true);
            
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
        
        //test
        
        
    }
    
}
