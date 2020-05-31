import React from 'react';
import { string, bool, number, oneOfType, arrayOf } from 'prop-types';
import { Slider as AntdSlider } from 'antd';

import { Placement } from '../../types/ui.types';

const Slider = ({ classes = '', isRange = false, ...rest }) => (
  <div className={classes}>
    <AntdSlider range={isRange} {...rest} />
  </div>
);

Slider.propTypes = {
  classes: string,
  isRange: bool,
  value: oneOfType([number, arrayOf(number)]),
  defaultValue: oneOfType([number, arrayOf(number)]),
  tooltipPlacement: Placement,
};

export default Slider;
