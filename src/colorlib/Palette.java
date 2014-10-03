/**
 * ##library.name##
 * ##library.sentence##
 * ##library.url##
 *
 * Copyright (c) ##copyright## ##author##
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software
 * and associated documentation files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute,
 * sublicense, and/or sell copies of the Software, and to permit persons to whom the Software
 * is furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED,
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR
 * PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE
 * FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE,
 * ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 * 
 * @author      ##author##
 * @modified    ##date##
 * @version     ##library.prettyVersion## (##library.version##)
 */

package colorlib;

import processing.core.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;

import java.util.HashSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

import colorlib.Swatch;

public class Palette
{

	protected PApplet p;
	protected ArrayList<Swatch> swatches;
	
	/**
	 * Creates an empty Palette object.
	 * @param parent reference to the main PApplet object.
	 */
	
	public Palette( final PApplet parent )
	{
		p = parent;
		swatches = new ArrayList<Swatch>();
	}
	
	/**
	 * Creates a Palette object from an array of colors.
	 * @param parent reference to the main PApplet object.
	 * @param colors Array of Processing colors.
	 */

	public Palette( final PApplet parent, int[] colors )
	{
		p = parent;
		swatches = new ArrayList<Swatch>();
		
		addColors( colors );
	}
	
	/**
	 * Adds a color to the Palette.
	 * @param color a Processing color.
	 */
	
	public Palette addColor( final int color )
	{
		swatches.add( new Swatch( p, color ) );
		return this;
	}

	/**
	 * Adds colors to the Palette.
	 * @param colors an array of Processing colors.
	 */
	
	public Palette addColors( final int[] colors )
	{
		for ( int i = 0; i < colors.length; i++ ) {
			swatches.add( new Swatch( p, colors[i] ) );
		}
		
		return this;
	}
		
	/* stub??? */
	public void createPalette()
	{
		notImplemented();
	}

	public void createPalette( final int color )
	{
		notImplemented();
	}

	/**
	 * Removes duplicate colors from the Palette
	 */
	
	public void removeDuplicateSwatches()
	{
	
		HashSet hs = new HashSet();
		
		for ( Swatch s : swatches ) {
			hs.add( new Integer( s.getColor() ) );
		}

		swatches = new ArrayList<Swatch>();
		
		Iterator iter = hs.iterator();
		
		int count = 0;
		
		while ( iter.hasNext() ) {
			swatches.add( new Swatch( p, ((Integer) iter.next()).intValue() ) );
			count++;
		}

	}
	
	/**
	 * Draws all color swatches of the Palette to the screen.
	 */
	
	public void drawSwatches()
	{
		drawSwatches( 120, 40 );
	}
	
	/**
	 * Draws all color swatches of the Palette to the screen.
	 * @param w Width of the Palette
	 * @param h Height of the Palette
	 */

	public void drawSwatches( final float w, final float h )
	{
		if ( swatches.size() > 0 ) {

			float swatchWidth = w / (float)swatches.size();
		
			int counter = 0;
		
			for ( Swatch s : swatches ) {
			
				p.fill( s.getColor() );
				p.noStroke();
				p.rect( swatchWidth * counter, 0, swatchWidth, h );
			
				counter++;
			}
		} else if ( swatches.size() == 0 ) {
			p.fill( p.color( 255, 255, 255 ) );
			p.noStroke();
			p.rect( 0, 0, w, h );
		}
	}
	
	/**
	 * Returns the color for the index number
	 * @param colorNumber number of the color you want to get
	 * @return
	 */
	
	public int getColor( int colorNumber )
	{
		return swatches.get( colorNumber ).getColor();
	}
	
	/**
	 * Returns the number of swatches in the Palette
	 * @return
	 */
	public int numSwatches()
	{
		return swatches.size();
	}
	
	
	
	public void rotateRGB( final int angle )
	{
		for ( Swatch s : swatches ) {
			s.rotateRGB( angle );			
		}
	}
	
	public void rotateRYB( final int angle )
	{
		for ( Swatch s : swatches ) {
			s.rotateRYB( angle );
			
		}	
	}
	
	
	// --------------------------------------------------------------------
	// Sort methods
	
	/**
	 * Sorts the Swatches in the palette by hue
	 */
	
	public void sortByHue()
	{
		notImplemented();
		
		// Code below doesn't work yet ??? Compiles fine but Throws NoSuchElementException in Processing
		// Either this breaks or the sort() function.
		
		/*
		Hashtable ht = new Hashtable();
		
		for ( Swatch s : swatches ) {
			
			Integer key = new Integer( (int)p.hue( s.getColor() ) );
			
			if ( ht.containsKey( key ) ) {
				
				((ArrayList) ht.get( key )).add( s );
				
			} else {
				
				ArrayList al = new ArrayList();
				al.add( s );
				ht.put( key, al );
			}
			
		}
		
		sort( ht );
		*/
	}
	
	/**
	 * Sorts the Swatches in the palette by saturation
	 */
	
	public void sortBySaturation()
	{
		notImplemented();
	}
	
	/**
	 * Sorts the Swatches in the palette by luminance
	 */
	public void sortByLuminance()
	{
		notImplemented();
	}
	
	public void sortByProximity()
	{
		notImplemented();
	}
	
	/**
	 * Main sort function
	 * @param ht
	 */
	private void sort( final Hashtable ht )
	{
		notImplemented();

		// Code below doesn't work yet ??? Compiles fine but Throws NoSuchElementException in Processing
		// Either this breaks or the sortByHue() function.
		
		/*
		Vector v = new Vector( ht.keySet() );
		
		Collections.sort( v );
		
		int count = 0;
		
		Iterator iter = v.iterator();
		
		swatches = new ArrayList<Swatch>();
		
		while ( iter.hasNext() ) {
			Integer key = (Integer) iter.next();
			ArrayList al = (ArrayList) ht.get( key );
			Iterator iter2 = al.iterator();
			while ( iter2.hasNext() ) {
				swatches.add( new Swatch( p, ((Integer) iter.next()).intValue() ) );
			}
		}
		*/
		
	}

	// --------------------------------------------------------------------
	// Search methods
	
	/**
	 * Returns the darkest color (Swatch?) from the Palette
	 */
	public int getDarkest()
	{
		notImplemented();
		return 0;
	}
	
	/**
	 * Returns the lightest color (Swatch?) from the Palette
	 */
	public int getLightest()
	{
		notImplemented();
		return 0;
	}
	
	/**
	 * Returns the average of all colors (Swatch?) from the Palette
	 */
	public int getAverage()
	{
		notImplemented();
		return 0;		
	}
	
	// --------------------------------------------------------------------
	
	/**
	 * Private method used to print "method not implemented yet to the Processing console.
	 * @return
	 */
	
	private void notImplemented()
	{
		String name = Thread.currentThread().getStackTrace()[2].getMethodName();		
		p.println( name + ": Method not implemented yet." );
	}
	
	
}