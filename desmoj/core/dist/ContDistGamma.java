package desmoj.core.dist;

import org.apache.commons.math.MathException;

import desmoj.core.simulator.Model;

/**
 * Distribution returning gamma distributed double values.
 * 
 * @version DESMO-J, Ver. 2.4.1 copyright (c) 2014
 * @author Peter Wueppen
 * 
 *         Licensed under the Apache License, Version 2.0 (the "License"); you
 *         may not use this file except in compliance with the License. You may
 *         obtain a copy of the License at
 *         http://www.apache.org/licenses/LICENSE-2.0
 * 
 *         Unless required by applicable law or agreed to in writing, software
 *         distributed under the License is distributed on an "AS IS" BASIS,
 *         WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 *         implied. See the License for the specific language governing
 *         permissions and limitations under the License.
 * 
 */

public class ContDistGamma extends ContDist {

	/**
	 * Distribution specific shape parameter alpha
	 */
	protected double alpha;

	/**
	 * Distribution specific scale parameter beta
	 */
	protected double beta;

	/**
	 * Creates a stream of pseudo random numbers following a gamma distribution.
	 * The specific parameters alpha and beta have to be given here at creation
	 * time.
	 * 
	 * @param owner
	 *            Model : The distribution's owner
	 * @param name
	 *            java.lang.String : The distribution's name
	 * @param alpha
	 *            double: Distribution specific shape parameter alpha
	 * @param beta
	 *            double : Distribution specific scale parameter beta
	 * @param showInReport
	 *            boolean : Flag for producing reports
	 * @param showInTrace
	 *            boolean : Flag for producing trace output
	 */
	public ContDistGamma(Model owner, String name, double alpha, double beta,
			boolean showInReport, boolean showInTrace) {
		super(owner, name, showInReport, showInTrace);
		this.alpha = alpha;
		this.beta = beta;
		// TODO Auto-generated constructor stub
	}

	/**
	 * Creates the default reporter for the GammaDist distribution.
	 * 
	 * @return Reporter : The reporter for the GammaDist distribution
	 * @see desmoj.core.report.ContDistGammaReporter
	 */
	public desmoj.core.report.Reporter createReporter() {

		return new desmoj.core.report.ContDistGammaReporter(this);

	}

	/**
	 * 
	 * @return double : Distribution specific shape parameter alpha
	 */
	public double getAlpha() {

		return alpha;
	}

	/**
	 * 
	 * @return double : Distribution specific scale parameter beta
	 */
	public double getBeta() {

		return beta;

	}

	/**
	 * Returns the next sample from this distribution. The value depends upon
	 * the seed, the number of values taken from the stream by using this method
	 * before and the alpha and beta parameters specified for this distribution.
	 * 
	 * @return Double : The next gamma distributed sample from this
	 *         distribution.
	 */
	public Double sample() {

		double newSample = -1; //
		double randomNumber = randomGenerator.nextDouble();
		org.apache.commons.math.distribution.GammaDistribution gammadist = new org.apache.commons.math.distribution.GammaDistributionImpl(
				alpha, beta);
		incrementObservations(); // increase count of samples

		if (isAntithetic()) {

			try {
				newSample = gammadist
						.inverseCumulativeProbability(1 - randomNumber);
			} catch (MathException e) {
			}
		} else {
			try {
				newSample = gammadist
						.inverseCumulativeProbability(randomNumber);
			} catch (MathException e) {
			}
		}

		if (this.currentlySendTraceNotes())
			this.traceLastSample(Double.toString(newSample));

		return newSample;
	}
}
