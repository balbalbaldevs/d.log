import './Dots.scss';

import classNames from 'classnames';
import React from 'react';

type AttributesProps = React.HTMLAttributes<HTMLElement>;
type Props = AttributesProps;

export default function Dots({ className, ...rest }: Props) {
  return (
    <i {...rest} className={classNames('dots', className)} aria-hidden>
      <span />
    </i>
  );
}
