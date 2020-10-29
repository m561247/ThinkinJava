package Interface.filters;

public class BandPass extends Filter {
	double lowCutoff, highCutoff;
	public BandPass(double lowCut, double highCut) {
		this.highCutoff = highCutoff;
		this.lowCutoff = lowCutoff;
	}
	public Waveform process(Waveform input) {
		return input;
	}
}
