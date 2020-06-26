```js
import Tabs from './Tabs';
const values = undefined;

const Tab1Content = () => {
  React.useEffect(() => {
    console.log('tab content 1 mounted');
  }, []);
  return <div>
      <h2>Tab content 1</h2>
      <p>Tab content 1Tab content 1Tab content 1Tab content 1Tab content 1Tab content 1Tab content 1Tab content 1Tab content 1Tab content 1Tab content 1Tab content 1Tab content 1</p>
  </div>;
};

const Tab2Content = () => {
  React.useEffect(() => {
    console.log('tab content 2 mounted');
  }, []);
  return <div>
      <h2>Tab content 2</h2>
      <p>Tab content 1Tab content 1Tab content 1Tab content 1Tab content 1Tab content 1Tab content 1Tab content 1Tab content 1Tab content 1Tab content 1Tab content 1Tab content 1</p>
  </div>;
};

const Tab3Content = () => {
  React.useEffect(() => {
    console.log('tab content 3 mounted');
  }, []);
  return <div>
      <h2>Tab content 3</h2>
      <p>Tab content 1Tab content 1Tab content 1Tab content 1Tab content 1Tab content 1Tab content 1Tab content 1Tab content 1Tab content 1Tab content 1Tab content 1Tab content 1</p>
  </div>;
};

// tabList
const tabList = [
  { 
    id: '1',
    tab: <Tabs.Tab iconName="search" iconPlacement="left" iconSize={10} name="Tab1" />
  },
  { 
    id: '2',
    tab: <Tabs.Tab iconName="search" iconPlacement="right" iconSize={10} name="Tab2" />
  },
  { 
    id: '3',
    tab: <Tabs.Tab iconName="search" iconPlacement="top" iconSize={10} name="Tab3" />
  },
  { 
    id: '4',
    tab: <Tabs.Tab iconName="search" iconPlacement="bottom" iconSize={10} name="Tab4" />
  },
  { 
    id: '5',
    tab:  <Tabs.Tab name="Tab5" />
  },
  { 
    id: '6',
    tab:  <Tabs.Tab name="Tab6" />
  },
];

const [selectedTab, setSelectedTab] = React.useState(tabList[0].id);

// Tab 클릭 상태 바꿔주는 것
const onChange = (id) => {
  setSelectedTab(id); // 1, 2, 
}

// 확인용
// React.useEffect(() => {
//   console.log(selectedTab, 'type', typeof selectedTab);
// }, [selectedTab]);

<>
<Tabs defaultActiveKey={tabList[0].id} onChange={onChange}>
  {tabList.map(it => (<Tabs.TabList tab={it.tab} key={it.id} disabled={it.id === '3'} />))}
</Tabs>
<Tabs.Panel>
  {selectedTab === '1' && <Tab1Content />}
  {selectedTab === '2' && <Tab2Content />}
  {selectedTab === '3' && <Tab3Content />}
  {selectedTab === '4' && <Tab1Content />}
  {selectedTab === '5' && <Tab2Content />}
  {selectedTab === '6' && <Tab3Content />}
</Tabs.Panel>
</>
```
