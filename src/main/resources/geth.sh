#
# command line 
geth --datadir~/data_testnet account new
# pass2 // 02517e3fcc7f95e35b8e350be3688821141d1674
# アカウントリストの表示
geth --datadir~/data_testnet account list
# ethereumスタート
geth --networkid 4649 --nodiscover --maxpeers 0 --datadir~/data_testnet console 2>>~/data_testnet/geth.log

nohup geth --networkid 4649 --nodiscover --maxpeers 0 --datadir~/data_testnet --mine --minerthreads 1 --rpc 2>>~/data_testnet/geth.log &
nohup geth --networkid 4649 --nodiscover --maxpeers 0 --datadir~/data_testnet --mine --minerthreads 1 --rpc 2>>~/data_testnet/geth.log &
geth attach rpc:http://localhost:8545

jobs
kill %%
geth attach rpc:http://localhost:8545
nohup geth --networkid 4649 --nodiscover --maxpeers 0 --datadir~/data_testnet --mine --minerthreads 1 --rpc --rpcaddr "0.0.0.0" --rpcport 8545 --rpccorsdomain "*" --rpcapi "admin,db,eth,debug,miner,net,shh,txpool,personal,web3"  2>>~/data_testnet/geth.log &
curl -X POST --data '{"jsonrpc":"2.0" , "method":"personal_newAccount","params":["pass3"],"id":10}' localhsot:8545

# curl -X POST --data '{"jsonrpc":"2.0" , "method":"personal_newAccount","params":["pass3"],"id":10}' localhost:8545
# {"jsonrpc":"2.0","id":10,"result":"0x65fce20dcb957d25a347a9bf356a7f633386a241"}

curl -X POST --data '{"jsonrpc":"2.0" , "method":"personal_listAccounts","params":[],"id":10}' localhost:8545

#curl -X POST --data '{"jsonrpc":"2.0" , "method":"personal_listAccounts","params":[],"id":10}' localhost:8545
#{"jsonrpc":"2.0","id":10,"result":
#["0xd79268b86aeb0996dad3ea2a9373e78fae512976",
#"0x195bc791f8b2c2924adb1932f755c5245a2a1450",
#"0x02517e3fcc7f95e35b8e350be3688821141d1674",
#"0x65fce20dcb957d25a347a9bf356a7f633386a241"]}


curl -X POST --data '{"jsonrpc":"2.0" , "method":"personal_unlockAccount","params":["0x65fce20dcb957d25a347a9bf356a7f633386a241","pass2",300],"id":10}' localhost:8545
curl -X POST --data '{"jsonrpc":"2.0" , "method":"personal_unlockAccount","params":["0x65fce20dcb957d25a347a9bf356a7f633386a241","pass3",300],"id":10}' localhost:8545
{"jsonrpc":"2.0","id":10,"result":true}
//0x195bc791f8b2c2924adb1932f755c5245a2a1450
curl -X POST --data '{"jsonrpc":"2.0" , "method":"personal_unlockAccount","params":["0x195bc791f8b2c2924adb1932f755c5245a2a1450","pass1",300],"id":10}' localhost:8545

curl -X POST --data '{"jsonrpc":"2.0" , "method":"eth_sendTransaction","params":[{"from" : "0x195bc791f8b2c2924adb1932f755c5245a2a1450","value" : "0x6F05B59D3B20000","to":"0x65fce20dcb957d25a347a9bf356a7f633386a241"}],"id":10}' localhost:8545
{"jsonrpc":"2.0","id":10,"result":"0xa6db3bb30940f6a5cdff348dffc4f4d5b44286f2963466f9c8657edcb0c92233"}
curl -X POST --data '{"jsonrpc":"2.0" , "method":"eth_getBalance","params":[ "0x195bc791f8b2c2924adb1932f755c5245a2a1450","latest"],"id":10}' localhost:8545
{"jsonrpc":"2.0","id":10,"result":"0x2242934be96518000"}
printf '%d\n' "0x2242934be96518000"
curl -X POST --data '{"jsonrpc":"2.0" , "method":"eth_getBalance","params":[ "0x65fce20dcb957d25a347a9bf356a7f633386a241","latest"],"id":10}' localhost:8545
# curl -X POST --data '{"jsonrpc":"2.0" , "method":"eth_getBalance","params":[ "0x65fce20dcb957d25a347a9bf356a7f633386a241","latest"],"id":10}' localhost:8545
{"jsonrpc":"2.0","id":10,"result":"0x6f05b59d3b20000"}

printf '%d\n' "0x6f05b59d3b20000"
#起動シェル
nohup geth --networkid 4649 --nodiscover --maxpeers 0 --datadir ~/data_testnet --mine --minerthreads 1 --rpc --rpcaddr "0.0.0.0" --rpcport 8545  --rpccorsdomain "*" --rpcapi "admin,db,eth,debug,miner,net,shh,txpool,personal,web3" --unlock 0,1 --password ~/data_testnet/password --verbosity 6 2>> ~/data_testnet/geth.log &
#console接続
geth attach rpc:http://localhost:8545
# UTC--2018-04-24T16-02-33.961849128Z--41965324355a99d98b120b7b507af9affa47f25e



#wisper
geth --shh --testnet --nodiscover console