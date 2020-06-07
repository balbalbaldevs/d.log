import React from 'react';

export enum LOADING_TYPE {
  SKELETON = 'skeleton',
  SPINNER = 'spinner',
  TEXT = 'text',
}

type AttributesProps = React.HTMLAttributes<HTMLSpanElement>;

type CustomProps = {
  type?: 'skeleton' | 'spinner' | 'text';
  rowNum?: number;
};

export type Props = AttributesProps & CustomProps;
