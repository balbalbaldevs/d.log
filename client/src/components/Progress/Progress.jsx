import React, { useEffect, useState } from 'react';
import { Progress as AntdProgress } from 'antd';
import { string, bool, number, oneOf } from 'prop-types';

import { PROGRESS_TYPE } from '../../types/constants';

const Progress = ({ classes = '', animated = false, percent, ...rest }) => {
  const [animationStep, setAnimationStep] = useState(0);

  useEffect(() => {
    if (animated && animationStep < percent) {
      setTimeout(
        () => setAnimationStep(animationStep + 1),
        animationStep < percent * 0.7 ? 50 : 100,
      );
    }
  }, [animated, animationStep, percent]);

  return (
    <div className={classes}>
      <AntdProgress percent={animationStep} {...rest} />
    </div>
  );
};

Progress.propTypes = {
  classes: string,
  type: oneOf([PROGRESS_TYPE.LINE, PROGRESS_TYPE.CIRCLE, PROGRESS_TYPE.DASHBOARD]),
  animated: bool,
  percent: number.isRequired,
};

export default Progress;
