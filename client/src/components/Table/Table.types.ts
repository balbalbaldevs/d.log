import { TableProps as AntdTableProps } from 'antd/es/table';
import React from 'react';

import { ColumnProps } from './components/Column/Column.types';

export type CustomProps<T> = {
  border?: boolean;
  children: ColumnProps<T>;
  data: T[];
  scrollX?: number | true;
  scrollY?: number;
  style?: React.CSSProperties;
};

export type TableProps<T> = Omit<AntdTableProps<T>, 'dataSource' | 'bordered' | 'scroll'> & CustomProps<T>;
