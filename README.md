## Understanding the Code
### Main file: [datarep.clj](https://github.com/mkersh/DataRep/blob/main/src/mambu/extensions/data_replication/datarep.clj) 
Key functions:
* ([resync-dwh](https://github.com/mkersh/DataRep/blob/5a18f4152f55fc4fc86b065466aa13d1df36057a/src/mambu/extensions/data_replication/datarep.clj#L587) ...) - Replicates data from a Mambu tenant to a local folder/file based data-lake/DWH
* [(terminal-ui)](https://github.com/mkersh/DataRep/blob/557ef030d5828476488c913ce4a9c1df6725696b/src/mambu/extensions/data_replication/datarep.clj#L652) - Simple UI for a stdout Terminal
   * Startup function when running the App. Called from [repl_start.clj::-main](https://github.com/mkersh/DataRep/blob/557ef030d5828476488c913ce4a9c1df6725696b/src/repl_start.clj#L41)

### File [file_dwh.clj](https://github.com/mkersh/DataRep/blob/main/src/mambu/extensions/data_replication/file_dwh.clj)
* Implements a folder/file based DWH
* This DWH is used to save Mambu data/objects when they are replicated
* ([save-object](https://github.com/mkersh/DataRep/blob/0cde6dbd9ba4497dee5b1b426223906c4318f6eb/src/mambu/extensions/data_replication/file_dwh.clj#L56) object context) - Saves an object to the DWH
    * Also see higher-level [datarep.clj](https://github.com/mkersh/DataRep/blob/main/src/mambu/extensions/data_replication/datarep.clj)::[save-object](https://github.com/mkersh/DataRep/blob/0cde6dbd9ba4497dee5b1b426223906c4318f6eb/src/mambu/extensions/data_replication/datarep.clj#L184) 

### API helper functions
* The API helper/abstractions that I use are defined in the [http.api](https://github.com/mkersh/DataRep/tree/main/src/http/api) namespace
* [api_pipe.clj](https://github.com/mkersh/DataRep/blob/main/src/http/api/api_pipe.clj) - Provides the top level API functions that I use
* [json_helper.clj](https://github.com/mkersh/DataRep/blob/main/src/http/api/json_helper.clj) - Lower level API helper functions used by api_pipe.clj and built on top of [http-kit](https://http-kit.github.io/)
* Understanding http.ENV is important if you are going to use this App. This is not stored in GitHub because it contains authentication details  
    * See [ENV-example.clj](https://github.com/mkersh/DataRep/blob/main/src/http/ENV-example.clj) 
    * Copy this into your own version of http.ENV
    * This is where you define the Mambu tenants and their logon details
    * See [(SETENV env)](https://github.com/mkersh/DataRep/blob/3ef5a6d52a6c4960d87e59f29d3bbab0fa6703b8/src/mambu/extensions/data_replication/datarep.clj#L634) for how the environment to use is setup
    * API calls refer to the env like this: ["{{\*env\*}}/clients"](https://github.com/mkersh/DataRep/blob/3ef5a6d52a6c4960d87e59f29d3bbab0fa6703b8/src/mambu/extensions/data_replication/datarep.clj#L223)
