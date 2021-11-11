# Bitcoin accounts Hacker

## Purpsoe : 

the project generate a csv file with private and public keys with it corresponding current balance from the main bitcoin blockchain.

the purpose is to proove by practice that the chance to find an none empty account (with some btc) is almost impossible. 

## Parameters
### P1 : Number of pairs to generate :
if equal under or equal zero it will generates infinite pairs, until the application is stopped
otherwise it will generate the appropriate Number of pairs mentioned in P1

### P2 : the file path where the values will be stored


## TODO : 
1 - Generate many files of a defined size (64mb, 128mb or 256mb)
2 - Generation will be in separate processes
3 - Create new project to mv the generated files into HDFS
4 - Create Hive Table
5 - Create Hive view with balances different from 0
6 - Generate Spark Job to update balances (read pubKeys from hive)

