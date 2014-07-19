/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.commons.math.analysis;

/**
 * A concrete {@link  UnivariateRealSolverFactory}.  This is the default solver factory
 * used by commons-math.
 * <p>
 * The default solver returned by this factory is a {@link BrentSolver}.</p>
 *
 * @version $Revision: 615734 $ $Date: 2008-01-27 23:10:03 -0700 (Sun, 27 Jan 2008) $
 */
public class UnivariateRealSolverFactoryImpl {
        
    /**
     * Default constructor.
     */
    public UnivariateRealSolverFactoryImpl() {
    }

    /**
     * Create a new {@link UnivariateRealSolver} for the given function.  The
     * actual solver returned is determined by the underlying factory.
     * 
     * This factory returns a {@link BrentSolver} instance.
     *
     * @param f the function.
     * @return the new solver.
     */
    public UnivariateRealSolver newDefaultSolver(UnivariateRealFunction f) {
        return newBrentSolver(f);
    }
    
    /**
     * Create a new {@link UnivariateRealSolver} for the given function.  The
     * solver is an implementation of the bisection method.
     * @param f the function.
     * @return the new solver.
     */
    public UnivariateRealSolver newBisectionSolver(UnivariateRealFunction f) {
        return new BisectionSolver(f);
    }

    /**
     * Create a new {@link UnivariateRealSolver} for the given function.  The
     * solver is an implementation of the Brent method.
     * @param f the function.
     * @return the new solver.
     */
    public UnivariateRealSolver newBrentSolver(UnivariateRealFunction f) {
        return new BrentSolver(f);
    }
    
    /**
     * Create a new {@link UnivariateRealSolver} for the given function.  The
     * solver is an implementation of Newton's Method.
     * @param f the function.
     * @return the new solver.
     */
    public UnivariateRealSolver newNewtonSolver(
        DifferentiableUnivariateRealFunction f) {
        
        return new NewtonSolver(f);
    }
    
    /**
     * Create a new {@link UnivariateRealSolver} for the given function.  The
     * solver is an implementation of the secant method.
     * @param f the function.
     * @return the new solver.
     */
    public UnivariateRealSolver newSecantSolver(UnivariateRealFunction f) {
        return new SecantSolver(f);
    }
}
