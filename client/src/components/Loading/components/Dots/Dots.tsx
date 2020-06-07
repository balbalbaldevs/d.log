import React from 'react';
import classNames from 'classnames';
import './Dots.scss';

type AttributesProps = React.HTMLAttributes<HTMLElement>;
type Props = AttributesProps;

export default function Dots({ className, ...rest }: Props) {
  return (
    <i {...rest} className={classNames('dots', className)} aria-hidden>
      <span />
    </i>
  );
}
