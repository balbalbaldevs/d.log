import React from 'react';
import './Skeleton.scss';

type Props = {
  rowNum: number;
};

export default function Skeleton({ rowNum }: Props) {
  const renderSkeleton = [...Array(rowNum).keys()].map((key) => <span key={key} className="skeleton" />);
  return <>{renderSkeleton}</>;
}
