import React from 'react';
import { Table as AntdTable } from 'antd';
import { TableProps } from './Table.types';
import Column from './components/Column/Column';
import './Table.scss';

function Table<T extends object = any>(props: TableProps<T>) {
  const {
    border = false,
    children,
    data,
    tableLayout = 'fixed',
    scrollY,
    scrollX,
    style,
    ...rest
  } = props;

  return <div className="table" style={style}>
    <AntdTable
      {...rest}
      bordered={border}
      dataSource={data}
      pagination={false}
      scroll={{ y: scrollY, x: scrollX, scrollToFirstRowOnChange: true }}
      tableLayout={tableLayout}
    >
      {children}
    </AntdTable>
  </div>;
}

export default Object.assign(Table, {
  Column,
});
