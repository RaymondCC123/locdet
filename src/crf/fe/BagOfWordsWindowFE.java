/**
 * 
 */
package crf.fe;

import java.io.Serializable;

import edu.cmu.minorthird.text.Span;
import edu.cmu.minorthird.text.TextLabels;
import edu.cmu.minorthird.text.learn.SpanFE;

/**
 * @author rex
 *
 */
public class BagOfWordsWindowFE extends SpanFE implements Serializable{
	
	
	private static final long serialVersionUID = 20140311L;
	protected int windowSize=1;
	
	public void setFeatureWindowSize(int n){
		windowSize=n;
	}

	public int getFeatureWindowSize(){
		return windowSize;
	}

	@Override
	public void extractFeatures(TextLabels labels, Span s) {
		from(s).tokens().emit();
		for(int i=0;i<windowSize;i++){
			from(s).left().token(-i-1).eq().emit();
			from(s).right().token(i).eq().emit();
		}

	}

}
