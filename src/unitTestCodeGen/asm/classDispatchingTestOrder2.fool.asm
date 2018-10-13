push 0
push 3
push 5
push 2
push classpaperino
new
lfp
push -2
lfp
add
lw
copy
lw
push 0
add
lc
js
halt

function0:
cfp
lra
push 12
srv
sra
pop
sfp
lrv
lra
js

function2:
cfp
lra
push 1235
srv
sra
pop
sfp
lrv
lra
js

function1:
cfp
lra
push 129
srv
sra
pop
sfp
lrv
lra
js
classpippo:
function0
classpaperino:
function1
function2
classnull:
