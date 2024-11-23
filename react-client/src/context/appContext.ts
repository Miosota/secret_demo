// import { string } from 'prop-types';
import { createContext } from 'react';

// export const UserNameContext = createContext('Svetaaaaa');

const UserNameContext = createContext({
    userName: "uName",
    setUserName: (uName:string) => {}
  });

 export default UserNameContext;