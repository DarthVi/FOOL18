push 0
push 12
push 1
push classtestClass
new
push 1
push classA
new
lfp
push -2
lfp
add
lw
copy
lw
push 1
add
lc
js
halt

function0:
cfp
lra
push 1
push 0
lfp
add
lw
calchoff
add
lw
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
lfp
push 1
lfp
lw
add
lw
copy
lw
push 0
add
lc
js
srv
sra
pop
sfp
lrv
lra
js

function3:
cfp
lra
push 1
srv
sra
pop
sfp
lrv
lra
js
classA:
function1
function2
function3
classtestClass:
function0
classnull:
