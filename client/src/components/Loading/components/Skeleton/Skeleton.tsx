import './Skeleton.scss';

import classNames from 'classnames';
import React, { HTMLAttributes } from 'react';

import { Props as LoadingProps } from '../../Loading.types';

type Props = HTMLAttributes<HTMLSpanElement> & {
  rowNum: number;
  fontSize?: LoadingProps['fontSize'];
};

export default function Skeleton({ className, rowNum, fontSize, ...rest }: Props) {
  const renderSkeleton = [...Array(rowNum).keys()].map((key) => (
    <span key={key} {...rest} className={classNames('skeleton', { [`size-${fontSize}`]: fontSize }, className)} />
  ));
  return <>{renderSkeleton}</>;
}
