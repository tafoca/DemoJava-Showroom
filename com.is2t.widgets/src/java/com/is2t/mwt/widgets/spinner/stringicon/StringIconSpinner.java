/*
 * Copyright 2014 IS2T. All rights reserved.
 * Use of this source code is governed by a BSD-style license that can be found at http://www.is2t.com/open-source-bsd-license/.
 */
package com.is2t.mwt.widgets.spinner.stringicon;



public interface StringIconSpinner {

	void setModel(StringIconValue model);

	void nextValue();

	void previousValue();

	StringIconElement getValue();
}
